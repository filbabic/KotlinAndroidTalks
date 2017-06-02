package com.babic.filip.kotlinandroidtalks.ui.note_input.bills

import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface

/**
 * Created by Filip Babic @cobe
 */
interface BillsNoteInterface {

    interface View : NoteInputInterface.View {

        fun showBillAmount(amount: String)

        fun showDeadline(deadline : String)
    }

    interface Presenter : NoteInputInterface.Presenter<View>
}