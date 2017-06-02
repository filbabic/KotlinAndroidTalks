package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.common.helper_functions.isValidBody
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface

/**
 * Created by Filip Babic @cobe
 */
abstract class BaseNoteInputPresenter<T : NoteInputInterface.View>(protected val database: DatabaseManager, protected val manager: FirebaseManager) : NoteInputInterface.Presenter<T> {

    protected lateinit var noteView: T

    protected var newNote = Note()

    override fun checkNoteData(noteInput: Note) {
        if (noteInput.isValidBody()) {
            noteView.showText(noteInput.text)
            noteView.showTitle(noteInput.title)
        }

        newNote = noteInput
    }

    override fun onDoneClick(noteInput: Note) {
        if (noteIsValid(noteInput)) {

            val noteCompletion: (Boolean, Note) -> Unit = { result, note -> onSaveNoteResponse(result, note) }

            val noteToSave = noteInput.copy(id = newNote.id, categoryName = newNote.categoryName)

            if (noteToSave.id.isValid()) {
                manager.updateNote(noteToSave, noteCompletion)
            } else {
                manager.saveNote(noteToSave, noteCompletion)
            }
        }
    }

    private fun noteIsValid(noteInput: Note): Boolean {
        val category = noteInput.category

        return with(noteInput) {
            val validBody = listOf(title, text).isValid()

            when (category) {
                is Category.Work -> with(noteInput) { validBody && category.colleagueName.isValid() }

                is Category.None -> validBody

                is Category.Shopping -> with(noteInput) {
                    val items = category.items

                    validBody && items.isValid() && items.isNotEmpty()
                }

                is Category.Bills -> with(noteInput) { validBody && category.amount > 0 && category.deadline.isValid() }
            }
        }
    }

    protected fun onSaveNoteResponse(isSuccessful: Boolean, note: Note) {
        if (isSuccessful) {
            database.saveNote(note)
            noteView.navigateBack()
        } else {
            noteView.showSaveNoteError()
        }
    }
}