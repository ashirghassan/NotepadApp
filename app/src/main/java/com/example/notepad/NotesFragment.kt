package com.example.notepad

import NotesAdapter
import android.app.AlertDialog
import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notepad.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    private lateinit var noteDatabaseHelper: NoteDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var userId: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        noteDatabaseHelper = NoteDatabaseHelper(context)
        val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        userId = sharedPreferences.getString("user_id", "") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true) // Indicate that this fragment has a menu
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(false) // This removes the back button
        }
        binding.recyclerViewNotes.layoutManager = LinearLayoutManager(context)

        notesAdapter = NotesAdapter(
            onDeleteClickListener = { note -> showDeleteConfirmationDialog(note, { notesAdapter.notifyItemChanged(notesAdapter.currentList.indexOf(note)) }) },
            onEditClickListener = { note -> showAddNoteDialog(note) } // Edit action
        )
        binding.recyclerViewNotes.adapter = notesAdapter

        // Swipe to delete functionality
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val noteToDelete = notesAdapter.currentList[position]
                showDeleteConfirmationDialog(noteToDelete, { notesAdapter.notifyItemChanged(position) })
            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {
                // Only draw the delete icon when swiping to the left
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE && dX < 0) {
                    val itemView = viewHolder.itemView
                    val deleteIcon = requireContext().getDrawable(R.drawable.ic_delete)
                    val iconMargin = (itemView.height - deleteIcon!!.intrinsicHeight) / 2
                    val iconTop = itemView.top + (itemView.height - deleteIcon.intrinsicHeight) / 2
                    val iconBottom = iconTop + deleteIcon.intrinsicHeight

                    val iconLeft = itemView.right - iconMargin - deleteIcon.intrinsicWidth
                    val iconRight = itemView.right - iconMargin
                    deleteIcon.setBounds(iconLeft, iconTop, iconRight, iconBottom)

                    deleteIcon.draw(c)
                }

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.recyclerViewNotes)

        loadNotes()

        binding.buttonAddNote.setOnClickListener {
            showAddNoteDialog()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_notes, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                showLogoutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(context)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Logout") { _, _ ->
                // Clear user preferences and navigate back to the login screen
                val sharedPreferences = requireActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                editor.apply()
                findNavController().navigate(R.id.action_notesFragment_to_loginFragment)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun showAddNoteDialog(note: Note? = null) {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_add_note, null)
        val editTextNote = dialogView.findViewById<EditText>(R.id.editTextNote)

        note?.let {
            editTextNote.setText(it.text)
        }

        AlertDialog.Builder(context)
            .setTitle(if (note == null) "Add Note" else "Edit Note")
            .setView(dialogView)
            .setPositiveButton(if (note == null) "Add" else "Update") { dialog, _ ->
                var noteText = editTextNote.text.toString()
                // Trim trailing empty lines
                noteText = noteText.trim().lines().filter { it.isNotBlank() }.joinToString("\n")

                if (noteText.isNotEmpty()) {
                    if (note == null) {
                        addNoteToDatabase(noteText)
                    } else {
                        updateNoteInDatabase(note.id, noteText)
                    }
                    dialog.dismiss()
                } else {
                    Toast.makeText(context, "Note cannot be empty", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }


    private fun addNoteToDatabase(noteText: String) {
        val noteId = noteDatabaseHelper.addNote(userId, noteText)
        val note = Note(noteId, noteText)
        notesAdapter.submitList(notesAdapter.currentList + note)
    }

    private fun loadNotes() {
        val cursor = noteDatabaseHelper.getNotes(userId)
        val notes = mutableListOf<Note>()
        while (cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_ID))
            val text = cursor.getString(cursor.getColumnIndexOrThrow(NoteDatabaseHelper.COLUMN_NOTE_TEXT))
            notes.add(Note(id, text))
        }
        cursor.close()
        notesAdapter.submitList(notes)
    }

    private fun showDeleteConfirmationDialog(note: Note, onDeleteCancel: () -> Unit) {
        AlertDialog.Builder(context)
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("Delete") { _, _ ->
                deleteNoteFromDatabase(note.id)
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                onDeleteCancel()
                dialog.dismiss()
            }
            .show()
    }

    private fun deleteNoteFromDatabase(noteId: Long) {
        val deletedRows = noteDatabaseHelper.deleteNote(noteId)
        if (deletedRows > 0) {
            Toast.makeText(context, "Note deleted successfully", Toast.LENGTH_SHORT).show()
            loadNotes() // Refresh the RecyclerView after deletion
        } else {
            Toast.makeText(context, "Failed to delete note", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateNoteInDatabase(noteId: Long, editedNoteText: String) {
        val updatedRows = noteDatabaseHelper.updateNote(noteId, editedNoteText)
        if (updatedRows > 0) {
            Toast.makeText(context, "Note updated successfully", Toast.LENGTH_SHORT).show()
            loadNotes() // Refresh the RecyclerView after update
        } else {
            Toast.makeText(context, "Failed to update note", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
