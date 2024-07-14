package com.example.notepad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0014\u0010+\u001a\u00020\u000f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u001e\u0010.\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000f00H\u0002J\b\u00101\u001a\u00020\u000fH\u0002J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00103\u001a\u00020\rH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/example/notepad/NotesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/notepad/databinding/FragmentNotesBinding;", "binding", "getBinding", "()Lcom/example/notepad/databinding/FragmentNotesBinding;", "noteDatabaseHelper", "Lcom/example/notepad/NoteDatabaseHelper;", "notesAdapter", "LNotesAdapter;", "userId", "", "addNoteToDatabase", "", "noteText", "deleteNoteFromDatabase", "noteId", "", "loadNotes", "onAttach", "context", "Landroid/content/Context;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "showAddNoteDialog", "note", "Lcom/example/notepad/Note;", "showDeleteConfirmationDialog", "onDeleteCancel", "Lkotlin/Function0;", "showLogoutDialog", "updateNoteInDatabase", "editedNoteText", "app_debug"})
public final class NotesFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.notepad.databinding.FragmentNotesBinding _binding;
    private com.example.notepad.NoteDatabaseHelper noteDatabaseHelper;
    private NotesAdapter notesAdapter;
    private java.lang.String userId;
    
    public NotesFragment() {
        super();
    }
    
    private final com.example.notepad.databinding.FragmentNotesBinding getBinding() {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull
    android.view.Menu menu, @org.jetbrains.annotations.NotNull
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void showLogoutDialog() {
    }
    
    private final void showAddNoteDialog(com.example.notepad.Note note) {
    }
    
    private final void addNoteToDatabase(java.lang.String noteText) {
    }
    
    private final void loadNotes() {
    }
    
    private final void showDeleteConfirmationDialog(com.example.notepad.Note note, kotlin.jvm.functions.Function0<kotlin.Unit> onDeleteCancel) {
    }
    
    private final void deleteNoteFromDatabase(long noteId) {
    }
    
    private final void updateNoteInDatabase(long noteId, java.lang.String editedNoteText) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}