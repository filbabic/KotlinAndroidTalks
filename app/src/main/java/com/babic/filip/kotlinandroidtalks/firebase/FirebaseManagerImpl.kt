package com.babic.filip.kotlinandroidtalks.firebase

import com.babic.filip.kotlinandroidtalks.common.extensions.getCategory
import com.babic.filip.kotlinandroidtalks.common.extensions.toFirebaseNote
import com.babic.filip.kotlinandroidtalks.common.extensions.toNote
import com.babic.filip.kotlinandroidtalks.data_objects.FirebaseNote
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Filip Babic @cobe
 */
class FirebaseManagerImpl(private val database: FirebaseDatabase) : FirebaseManager {

    override fun getNotes(completion: (List<Note>) -> Unit) {
        val notes = database.reference

        notes.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError?) = completion(listOf())

            override fun onDataChange(snapshot: DataSnapshot?) {
                val items = snapshot?.children?.map { it.getValue(FirebaseNote::class.java) } ?: listOf()

                val categories = items.map { getCategory(it.categoryName, it.extraData) }
                val notesList = items.zip(categories) { item, category -> item.toNote().copy(category = category) }

                completion(notesList)
            }
        })
    }

    override fun saveNote(note: Note, completion: (Boolean, Note) -> Unit) {
        val newNoteRef = database.reference.push()

        val newNote = note.copy(id = newNoteRef.key)
        val noteToSave = newNote.toFirebaseNote()

        newNoteRef.setValue(noteToSave).addOnCompleteListener { completion(it.isSuccessful, newNote) }
    }

    override fun updateNote(note: Note, completion: (Boolean, Note) -> Unit) {
        val reference = database.reference.child(note.id)

        reference.setValue(note).addOnCompleteListener { completion(it.isSuccessful, note) }
    }

    override fun deleteNote(id: String, completion: (Boolean, String) -> Unit) {
        val reference = database.reference.child(id)

        reference.setValue(null).addOnCompleteListener { completion(it.isSuccessful, id) }
    }
}