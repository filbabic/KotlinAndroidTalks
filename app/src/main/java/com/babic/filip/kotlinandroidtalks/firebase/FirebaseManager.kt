package com.babic.filip.kotlinandroidtalks.firebase

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote

/**
 * Created by Filip Babic @cobe
 */
interface FirebaseManager {

    fun getNotes(completion: (List<KotlinNote>) -> Unit)

    fun saveNote(kotlinNote: KotlinNote, completion: (Boolean, KotlinNote) -> Unit)

    fun updateNote(note: KotlinNote, completion: (Boolean, KotlinNote) -> Unit)

    fun deleteNote(id: String, completion: (Boolean, String) -> Unit)
}