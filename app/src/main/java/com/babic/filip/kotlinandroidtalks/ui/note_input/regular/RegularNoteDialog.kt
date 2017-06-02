package com.babic.filip.kotlinandroidtalks.ui.note_input.regular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.base.BaseNoteInputDialog
import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface
import kotlinx.android.synthetic.main.dialog_regular_note.*
import kotlinx.android.synthetic.main.layout_note_input.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class RegularNoteDialog : BaseNoteInputDialog(), NoteInputInterface.View {

    @Inject lateinit var presenter: RegularNoteInterface.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.dialog_regular_note, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkData()
    }

    override fun initUI() {
        doneAction.setOnClickListener { presenter.checkNoteData(noteInput = Note(title = titleInput.input, text = textInput.input)) }
    }

    override fun injectDependencies() {
        App.component.inject(this)
        presenter.setView(view = this)
    }

    private fun checkData() {
        val note = arguments?.getSerializable(KEY_NOTE) as? Note ?: Note()
        presenter.checkNoteData(note)
    }
}