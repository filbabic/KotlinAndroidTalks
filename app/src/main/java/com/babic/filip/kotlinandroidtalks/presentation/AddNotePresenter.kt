package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.ui.add.AddNoteInterface
import java.util.*

/**
 * Created by Filip Babic @cobe
 */
class AddNotePresenter(private val database: DatabaseManager) : AddNoteInterface.Presenter {

    private lateinit var addNoteView: AddNoteInterface.View

    override fun setView(view: AddNoteInterface.View) {
        this.addNoteView = view
    }

    override fun onDoneClick(title: String, text: String) {
        if (listOf(title, text).isValid()) {
            val timeStamp = Date()
            val note = KotlinNote(title, text, timestamp = timeStamp.toString())

            database.saveNote(note)

            addNoteView.navigateBack()
        }
    }
}