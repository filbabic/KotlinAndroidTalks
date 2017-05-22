package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.common.constants.KEY_ID
import com.babic.filip.kotlinandroidtalks.common.extensions.*
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.data_objects.RealmKotlinNote
import io.realm.Realm

/**
 * Created by Filip Babic @cobe
 */
class DatabaseManagerImpl(private val realm: Realm) : DatabaseManager {

    override fun syncNotes(notes: List<KotlinNote>) {
        realm.deleteList { where(RealmKotlinNote::class.java) }

        realm.saveList(notes.map { it.toRealmNote() })
    }

    override fun getNotes(): List<KotlinNote> = realm.getCopies { where(RealmKotlinNote::class.java) }.map { it.toNote() }

    override fun deleteNote(id: String) = realm.deleteObject { where(RealmKotlinNote::class.java).equalTo(KEY_ID, id) }

    override fun saveNote(note: KotlinNote) = realm.saveObject(note.toRealmNote())
}