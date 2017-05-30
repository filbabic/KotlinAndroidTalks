package com.babic.filip.kotlinandroidtalks.firebase

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

        notes.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError?) = completion(listOf())

            override fun onDataChange(snapshot: DataSnapshot?) {
                val items = snapshot?.children?.map { it.getValue(Note::class.java) }

                completion(items ?: listOf())
            }
        })
    }

    override fun saveNote(note: Note, completion: (Boolean, Note) -> Unit) {
        val newNoteRef = database.reference.push()

        val noteToSave = note.copy(id = newNoteRef.key)

        newNoteRef.setValue(noteToSave).addOnCompleteListener { completion(it.isSuccessful, noteToSave) }
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