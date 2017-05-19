package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.AddNoteInterface
import java.util.*

/**
 * Created by Filip Babic @cobe
 */
class AddNotePresenter(private val database: DatabaseManager) : AddNoteInterface.Presenter {

    private lateinit var addNoteView: AddNoteInterface.View

    private var newNote = KotlinNote()

    override fun setView(view: AddNoteInterface.View) {
        this.addNoteView = view
    }

    override fun checkNote(note: KotlinNote) {
        if (listOf(note.text, note.title, note.timestamp).isValid()) {
            addNoteView.showText(note.text)
            addNoteView.showTitle(note.title)

            newNote = note
        }
    }

    override fun onDoneClick(title: String, text: String) {
        if (listOf(title, text).isValid()) {

            val note = if (newNote.timestamp.isValid()) {
                newNote.copy(title = title, text = text, position = -1)
            } else {
                KotlinNote(title, text, timestamp = Date().toString())
            }

            database.saveNote(note)
            addNoteView.navigateBack()
        }
    }
}