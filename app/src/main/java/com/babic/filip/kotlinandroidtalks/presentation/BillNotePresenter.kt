package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.helper_functions.isValidBody
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.bills.BillsNoteInterface

/**
 * Created by Filip Babic @cobe
 */
class BillNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager) : BaseNoteInputPresenter<BillsNoteInterface.View>(databaseManager, firebaseManager), BillsNoteInterface.Presenter {

    override fun setView(view: BillsNoteInterface.View) {
        this.noteView = view
    }

    override fun checkNoteData(noteInput: Note) {
        super.checkNoteData(noteInput)

        val category = noteInput.category

        if (noteInput.isValidBody() && category is Category.Bills) {
            noteView.showBillAmount(category.amount.toString())
        }
    }
}