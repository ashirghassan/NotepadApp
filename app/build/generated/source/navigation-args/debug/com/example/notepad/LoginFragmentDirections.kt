package com.example.notepad

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToNotesFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_notesFragment)
  }
}
