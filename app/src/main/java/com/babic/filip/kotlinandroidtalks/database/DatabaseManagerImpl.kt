package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.common.constants.KEY_TITLE
import com.babic.filip.kotlinandroidtalks.common.extensions.*
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.data_objects.RealmKotlinNote
import io.realm.Realm

/**
 * Created by Filip Babic @cobe
 */
class DatabaseManagerImpl(private val realm: Realm) : DatabaseManager {

    override fun getNotes(): List<KotlinNote> = realm.getCopies { where(RealmKotlinNote::class.java) }.map { it.toNote() }

    override fun deleteNote(note: KotlinNote) = realm.deleteObject { where(RealmKotlinNote::class.java).equalTo(KEY_TITLE, note.title) }

    override fun saveNote(note: KotlinNote) = realm.saveObject(note.toRealmNote())
}