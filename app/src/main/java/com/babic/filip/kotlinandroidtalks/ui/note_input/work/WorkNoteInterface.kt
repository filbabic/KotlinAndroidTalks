package com.babic.filip.kotlinandroidtalks.ui.note_input.work

import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface

/**
 * Created by Filip Babic @cobe
 */
interface WorkNoteInterface {

    interface View : NoteInputInterface.View {

        fun showColleague(colleagueName: String)
    }

    interface Presenter : NoteInputInterface.Presenter<View>
}