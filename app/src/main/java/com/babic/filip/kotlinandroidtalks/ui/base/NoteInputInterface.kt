package com.babic.filip.kotlinandroidtalks.ui.base

import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
interface NoteInputInterface {

    interface View : BaseView {

        fun showTitle(title: String)

        fun showText(text: String)

        fun showSaveNoteError()
    }

    interface Presenter<in T : View> : BasePresenter<T> {

        fun onDoneClick(noteInput: Note)

        fun checkNoteData(noteInput: Note)
    }
}