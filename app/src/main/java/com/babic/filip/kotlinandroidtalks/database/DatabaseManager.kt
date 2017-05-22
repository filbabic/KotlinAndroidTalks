package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote

/**
 * Created by Filip Babic @cobe
 */
interface DatabaseManager {

    fun syncNotes(notes: List<KotlinNote>)

    fun getNotes(): List<KotlinNote>

    fun saveNote(note: KotlinNote)

    fun deleteNote(id: String)
}