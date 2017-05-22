package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.holder.NotesHolder
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteInterface

/**
 * Created by Filip Babic @cobe
 */
class NotesPresenter(private val database: DatabaseManager, private val manager: FirebaseManager) : NoteInterface.Presenter {

    private lateinit var notesView: NoteInterface.View

    private var isFilterOpen = false

    override fun setView(view: NoteInterface.View) {
        this.notesView = view
    }

    override fun getNotes() = manager.getNotes({ syncNotes(it) })

    private fun syncNotes(notes: List<KotlinNote>) {
        database.syncNotes(notes)

        showNotes(notes)
    }

    override fun onFilterChanged(filter: String) {
        val filteredNotes = database.getNotes().filter { it.title.contains(filter, true) || it.text.contains(filter, true) } //ignore case = true

        showNotes(filteredNotes)
    }

    private fun showNotes(notes: List<KotlinNote>) {
        val holders = notes.map(::NotesHolder)

        holders.forEach {
            it.setOnClickAction { onNoteClick(it) }
            it.setOnLongClickAction { onNoteLongClick(it) }
        }

        notesView.showNotes(holders)
    }

    private fun onNoteLongClick(note: KotlinNote) {
        if (note.id.isValid()) { //a valid position was clicked
            notesView.showDeleteNoteDialog({ deleteNote(note) })
        }
    }

    private fun deleteNote(note: KotlinNote) = manager.deleteNote(note.id, { result, id -> onDeleteNoteResult(result, id) })

    private fun onDeleteNoteResult(isSuccessful: Boolean, id: String) {
        if (isSuccessful) {
            notesView.deleteNote(id)
            database.deleteNote(id)
        }
    }

    private fun onNoteClick(note: KotlinNote) = notesView.startEdit(note)

    override fun onAddNoteClick() = notesView.startAddNote()

    override fun onFilterClick() {
        if (isFilterOpen) {
            notesView.hideFilter()
            getNotes()
        } else {
            notesView.showFilter()
        }

        isFilterOpen = !isFilterOpen
    }

    override fun onBackClick() = notesView.navigateBack()
}