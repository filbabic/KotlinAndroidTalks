package com.babic.filip.kotlinandroidtalks.ui.notes

import com.babic.filip.kotlinandroidtalks.presentation.BasePresenter
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder

/**
 * Created by Filip Babic @cobe
 */
interface NoteInterface {

    interface View {

        fun navigateBack() {}

        fun showDeleteNoteDialog(onDeleteClick: () -> Unit)

        fun showNotes(notes: List<FlexibleNoteHolder>)

        fun deleteNote(position: Int)
    }

    interface Presenter : BasePresenter<View> {

        fun onSetup()
    }
}