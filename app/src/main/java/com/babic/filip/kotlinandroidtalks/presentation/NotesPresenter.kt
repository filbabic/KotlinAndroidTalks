package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.extensions.emptyCategoryFromName
import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.Note
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

    private fun syncNotes(notes: List<Note>) {
        database.syncNotes(notes)

        showNotes(notes)
    }

    override fun onFilterChanged(filter: String) {
        val filteredNotes = database.getNotes().filter { it.title.contains(filter, true) || it.text.contains(filter, true) } //ignore case = true

        showNotes(filteredNotes)
    }

    private fun showNotes(notes: List<Note>) {
        val holders = notes.map(::NotesHolder)

        holders.forEach {
            it.setOnClickAction { onNoteClick(it) }
            it.setOnLongClickAction { onNoteLongClick(it) }
        }

        notesView.showNotes(holders)
    }

    private fun onNoteLongClick(note: Note) {
        if (note.id.isValid()) { //a valid note was clicked
            notesView.showDeleteNoteDialog({ deleteNote(note) })
        }
    }

    private fun deleteNote(note: Note) = manager.deleteNote(note.id, { result, id -> onDeleteNoteResult(result, id) })

    private fun onDeleteNoteResult(isSuccessful: Boolean, id: String) {
        if (isSuccessful) {
            notesView.deleteNote(id)
            database.deleteNote(id)
        }
    }

    override fun onAddNoteClick() = notesView.showNoteCategoryPicker()

    override fun onCategoryPicked(category: String) {
        if (category.isValid()) {
            onNoteClick(Note(category = emptyCategoryFromName(category)))
        }
    }

    private fun onNoteClick(note: Note) = when (note.category) {
        is Category.None -> notesView.showRegularNoteDialog(note)
        is Category.Work -> notesView.showWorkNoteDialog(note)
        is Category.Bills -> notesView.showBillsNoteDialog(note)
        is Category.Shopping -> notesView.showShoppingNoteDialog(note)
    }

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