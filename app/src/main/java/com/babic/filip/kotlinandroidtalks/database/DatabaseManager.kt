package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote

/**
 * Created by Filip Babic @cobe
 */
interface DatabaseManager {

    fun getNotes(): List<KotlinNote>

    fun saveNote(note: KotlinNote)

    fun deleteNote(note: KotlinNote)
}