package com.babic.filip.kotlinandroidtalks.firebase

import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
interface FirebaseManager {

    fun getNotes(completion: (List<Note>) -> Unit)

    fun saveNote(note: Note, completion: (Boolean, Note) -> Unit)

    fun updateNote(note: Note, completion: (Boolean, Note) -> Unit)

    fun deleteNote(id: String, completion: (Boolean, String) -> Unit)
}