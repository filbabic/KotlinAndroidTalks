package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.helper_functions.isValidBody
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.work.WorkNoteInterface

/**
 * Created by Filip Babic @cobe
 */
class WorkNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager) : BaseNoteInputPresenter<WorkNoteInterface.View>(databaseManager, firebaseManager), WorkNoteInterface.Presenter {

    override fun setView(view: WorkNoteInterface.View) {
        this.noteView = view
    }

    override fun checkNoteData(noteInput: Note) {
        super.checkNoteData(noteInput)

        val category = noteInput.category

        if (noteInput.isValidBody() && category is Category.Work) {
            noteView.showColleague(category.colleagueName)
        }
    }
}