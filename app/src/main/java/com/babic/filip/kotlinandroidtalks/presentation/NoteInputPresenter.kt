package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.AddNoteInterface

/**
 * Created by Filip Babic @cobe
 */
class NoteInputPresenter(private val database: DatabaseManager, private val manager: FirebaseManager) : AddNoteInterface.Presenter {

    private lateinit var addNoteView: AddNoteInterface.View

    private var newNote = Note()

    override fun setView(view: AddNoteInterface.View) {
        this.addNoteView = view
    }

    override fun checkNote(note: Note) {
        if (listOf(note.text, note.title, note.id).isValid()) {
            addNoteView.showText(note.text)
            addNoteView.showTitle(note.title)

            newNote = note
        }
    }

    override fun onDoneClick(title: String, text: String) {
        if (listOf(title, text).isValid()) {

            val noteCompletion: (Boolean, Note) -> Unit = { result, note -> onSaveNoteResponse(result, note) }

            if (newNote.id.isValid()) {
                val updatedNote = newNote.copy(title = title, text = text)
                manager.updateNote(updatedNote, noteCompletion)
            } else {
                val newNote = Note(title = title, text = text)
                manager.saveNote(newNote, noteCompletion)
            }
        }
    }

    private fun onSaveNoteResponse(isSuccessful: Boolean, note: Note) {
        if (isSuccessful) {
            database.saveNote(note)
            addNoteView.navigateBack()
        } else {
            addNoteView.showSaveNoteError()
        }
    }
}