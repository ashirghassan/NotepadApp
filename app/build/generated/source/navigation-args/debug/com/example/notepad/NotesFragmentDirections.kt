package com.example.notepad

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class NotesFragmentDirections private constructor() {
  public companion object {
    public fun actionNotesFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_notesFragment_to_loginFragment)
  }
}
