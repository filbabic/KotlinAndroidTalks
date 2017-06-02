package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping

import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface

/**
 * Created by Filip Babic @cobe
 */
interface ShoppingNoteInterface {

    interface View : NoteInputInterface.View {

    }

    interface Presenter : NoteInputInterface.Presenter<View>
}