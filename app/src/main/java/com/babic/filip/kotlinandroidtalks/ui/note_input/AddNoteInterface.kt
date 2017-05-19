package com.babic.filip.kotlinandroidtalks.ui.note_input

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.ui.base.BasePresenter
import com.babic.filip.kotlinandroidtalks.ui.base.BaseView

/**
 * Created by Filip Babic @cobe
 */
interface AddNoteInterface {

    interface View : BaseView {

        fun showTitle(title: String)

        fun showText(text: String)
    }

    interface Presenter : BasePresenter<View> {

        fun onDoneClick(title: String, text: String)

        fun checkNote(note: KotlinNote)
    }
}