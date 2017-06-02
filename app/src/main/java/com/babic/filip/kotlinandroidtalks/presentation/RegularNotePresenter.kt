package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.regular.RegularNoteInterface

/**
 * Created by Filip Babic @cobe
 */
class RegularNotePresenter(database: DatabaseManager, manager: FirebaseManager) : BaseNoteInputPresenter<NoteInputInterface.View>(database, manager), RegularNoteInterface.Presenter {

    override fun setView(view: NoteInputInterface.View) {
        this.noteView = view
    }
}