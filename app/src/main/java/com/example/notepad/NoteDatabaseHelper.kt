package com.example.notepad

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "notes.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "notes"
        const val COLUMN_ID = "_id"
        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_NOTE_TEXT = "note_text"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "$COLUMN_USER_ID TEXT, "
                + "$COLUMN_NOTE_TEXT TEXT)")
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addNote(userId: String, noteText: String): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_USER_ID, userId)
            put(COLUMN_NOTE_TEXT, noteText)
        }
        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun getNotes(userId: String): Cursor {
        val db = this.readableDatabase
        return db.query(TABLE_NAME, arrayOf(COLUMN_ID, COLUMN_NOTE_TEXT), "$COLUMN_USER_ID=?", arrayOf(userId), null, null, null)
    }

    fun updateNote(id: Long, noteText: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NOTE_TEXT, noteText)
        }
        return db.update(TABLE_NAME, contentValues, "$COLUMN_ID=?", arrayOf(id.toString()))
    }

    fun deleteNote(id: Long): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "$COLUMN_ID=?", arrayOf(id.toString()))
    }
}
