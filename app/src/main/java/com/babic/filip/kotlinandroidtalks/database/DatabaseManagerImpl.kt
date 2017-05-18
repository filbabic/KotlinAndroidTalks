package com.babic.filip.kotlinandroidtalks.database

import com.babic.filip.kotlinandroidtalks.common.constants.KEY_TITLE
import com.babic.filip.kotlinandroidtalks.common.extensions.deleteObject
import com.babic.filip.kotlinandroidtalks.common.extensions.getCopies
import com.babic.filip.kotlinandroidtalks.common.extensions.saveObject
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import io.realm.Realm

/**
 * Created by Filip Babic @cobe
 */
class DatabaseManagerImpl(private val realm: Realm) : DatabaseManager {

    override fun getNotes(): List<KotlinNote> = realm.getCopies { where(KotlinNote::class.java) }

    override fun deleteNote(note: KotlinNote) = realm.deleteObject { where(KotlinNote::class.java).equalTo(KEY_TITLE, note.title) }

    override fun saveNote(note: KotlinNote) = realm.saveObject(note)
}