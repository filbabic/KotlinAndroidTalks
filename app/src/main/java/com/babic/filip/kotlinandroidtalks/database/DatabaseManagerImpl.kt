package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.common.constants.KEY_ID
import com.babic.filip.kotlinandroidtalks.common.extensions.*
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.data_objects.RealmNote
import io.realm.Realm

/**
 * Created by Filip Babic @cobe
 */
class DatabaseManagerImpl(private val realm: Realm) : DatabaseManager {

    override fun syncNotes(notes: List<Note>) = with(realm) {
        deleteList { where(RealmNote::class.java) }
        saveList(notes.map { it.toRealmNote() })
    }

    override fun getNotes(): List<Note> = realm.getCopies { where(RealmNote::class.java) }.map { it.toNote() }

    override fun deleteNote(id: String) = realm.deleteObject { where(RealmNote::class.java).equalTo(KEY_ID, id) }

    override fun saveNote(note: Note) = with(note) { realm.saveObject(toRealmNote()) }
}