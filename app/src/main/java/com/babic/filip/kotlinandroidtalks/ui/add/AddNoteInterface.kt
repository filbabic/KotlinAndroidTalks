package com.babic.filip.kotlinandroidtalks.ui.add

import com.babic.filip.kotlinandroidtalks.ui.base.BasePresenter
import com.babic.filip.kotlinandroidtalks.ui.base.BaseView

/**
 * Created by Filip Babic @cobe
 */
interface AddNoteInterface {

    interface View : BaseView {

    }


    interface Presenter : BasePresenter<View> {

        fun onDoneClick(title: String, text: String)
    }
}