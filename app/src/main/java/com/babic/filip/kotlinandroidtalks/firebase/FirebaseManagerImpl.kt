package com.babic.filip.kotlinandroidtalks.firebase

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * Created by Filip Babic @cobe
 */
class FirebaseManagerImpl(private val database: FirebaseDatabase) : FirebaseManager {

    override fun getNotes(completion: (List<KotlinNote>) -> Unit) {
        val notes = database.reference

        notes.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError?) = completion(listOf())

            override fun onDataChange(snapshot: DataSnapshot?) {
                val items = snapshot?.children?.map { it.getValue(KotlinNote::class.java) }

                completion(items ?: listOf())
            }
        })
    }

    override fun saveNote(kotlinNote: KotlinNote, completion: (Boolean, KotlinNote) -> Unit) {
        val reference = database.reference
        val newNoteRef = reference.push()

        val noteToSave = kotlinNote.copy(id = newNoteRef.key)

        newNoteRef.setValue(noteToSave).addOnCompleteListener { completion(it.isSuccessful, noteToSave) }
    }

    override fun updateNote(note: KotlinNote, completion: (Boolean, KotlinNote) -> Unit) {
        val reference = database.reference.child(note.id)

        reference.setValue(note).addOnCompleteListener { completion(it.isSuccessful, note) }
    }

    override fun deleteNote(id: String, completion: (Boolean, String) -> Unit) {
        val reference = database.reference.child(id)

        reference.setValue(null).addOnCompleteListener { completion(it.isSuccessful, id) }
    }
}