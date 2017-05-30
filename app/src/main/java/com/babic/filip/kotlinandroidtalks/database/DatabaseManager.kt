package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
interface DatabaseManager {

    fun syncNotes(notes: List<Note>)

    fun getNotes(): List<Note>

    fun saveNote(note: Note)

    fun deleteNote(id: String)
}