package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.ui.holder.NotesHolder
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteInterface

/**
 * Created by Filip Babic @cobe
 */
class NotesPresenter(private val database: DatabaseManager) : NoteInterface.Presenter {

    private lateinit var notesView: NoteInterface.View

    override fun setView(view: NoteInterface.View) {
        this.notesView = view
    }

    override fun onSetup() {
        val notes = database.getNotes()

        val holders = notes.map(::NotesHolder)
        holders.forEach {
            it.setOnClickAction { onNoteClick(it) }
            it.setOnLongClickAction { onNoteLongClick(it) }
        }
    }

    private fun onNoteLongClick(position: Int) {
        if (position != -1) { //a valid position was clicked
            notesView.showDeleteNoteDialog({ deleteNote(position) })
        }
    }

    private fun deleteNote(position: Int) = notesView.deleteNote(position)

    private fun onNoteClick(note: KotlinNote) {

    }

    override fun onBackClick() {
    }

}