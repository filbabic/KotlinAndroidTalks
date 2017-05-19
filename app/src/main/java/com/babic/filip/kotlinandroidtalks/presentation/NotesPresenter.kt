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

    override fun getNotes() {
        val notes = database.getNotes()

        val holders = notes.map(::NotesHolder)
        holders.forEach {
            it.setOnClickAction { onNoteClick(it) }
            it.setOnLongClickAction { onNoteLongClick(it) }
        }

        notesView.showNotes(holders)
    }

    private fun onNoteLongClick(note: KotlinNote) {
        if (note.position != -1) { //a valid position was clicked
            notesView.showDeleteNoteDialog({ deleteNote(note) })
        }
    }

    private fun deleteNote(note: KotlinNote) {
        notesView.deleteNote(note.position)
        database.deleteNote(note)
    }

    private fun onNoteClick(note: KotlinNote) = notesView.startEdit(note)

    override fun onAddNoteClick() = notesView.startAddNote()

    override fun onBackClick() = notesView.navigateBack()
}