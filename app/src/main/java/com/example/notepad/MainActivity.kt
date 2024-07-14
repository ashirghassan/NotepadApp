package com.example.notepad

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("logged_in", false)

        if (isLoggedIn) {
            // Log message for debugging
            Log.d("MainActivity", "User is already logged in, navigating to NotesFragment")

            // User is already logged in, navigate to NotesFragment
            setContentView(R.layout.activity_main)
            val navController = findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.notesFragment)
            return
        }

        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}



