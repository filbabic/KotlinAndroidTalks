package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.ShoppingNoteInterface

/**
 * Created by Filip Babic @cobe
 */
class ShoppingNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager) : BaseNoteInputPresenter<ShoppingNoteInterface.View>(databaseManager, firebaseManager) {

    override fun setView(view: ShoppingNoteInterface.View) {
        this.noteView = view
    }
}