package com.example.notepad;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016J\u0016\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u0018"}, d2 = {"Lcom/example/notepad/NoteDatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addNote", "", "userId", "", "noteText", "deleteNote", "", "id", "getNotes", "Landroid/database/Cursor;", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "updateNote", "Companion", "app_debug"})
public final class NoteDatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DATABASE_NAME = "notes.db";
    public static final int DATABASE_VERSION = 1;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TABLE_NAME = "notes";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String COLUMN_ID = "_id";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String COLUMN_USER_ID = "user_id";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String COLUMN_NOTE_TEXT = "note_text";
    @org.jetbrains.annotations.NotNull
    public static final com.example.notepad.NoteDatabaseHelper.Companion Companion = null;
    
    public NoteDatabaseHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.NotNull
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override
    public void onUpgrade(@org.jetbrains.annotations.NotNull
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final long addNote(@org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    java.lang.String noteText) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.database.Cursor getNotes(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    public final int updateNote(long id, @org.jetbrains.annotations.NotNull
    java.lang.String noteText) {
        return 0;
    }
    
    public final int deleteNote(long id) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/notepad/NoteDatabaseHelper$Companion;", "", "()V", "COLUMN_ID", "", "COLUMN_NOTE_TEXT", "COLUMN_USER_ID", "DATABASE_NAME", "DATABASE_VERSION", "", "TABLE_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}