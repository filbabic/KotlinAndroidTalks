package com.babic.filip.kotlinandroidtalks.ui.note_input.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.base.BaseNoteInputDialog
import kotlinx.android.synthetic.main.dialog_work_note.*
import kotlinx.android.synthetic.main.layout_note_input.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class WorkNoteDialog : BaseNoteInputDialog(), WorkNoteInterface.View {

    @Inject lateinit var presenter: WorkNoteInterface.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.dialog_work_note, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkData()
    }

    override fun initUI() {
        doneAction.setOnClickListener {
            val note = Note(title = titleInput.input, text = textInput.input, category = Category.Work(colleagueNameInput.input))
            presenter.onDoneClick(noteInput = note)
        }
    }

    override fun injectDependencies() {
        App.component.inject(this)
        presenter.setView(this)
    }

    private fun checkData() {
        val note = arguments?.getSerializable(KEY_NOTE) as? Note ?: Note()
        presenter.checkNoteData(note)
    }

    override fun showColleague(colleagueName: String) {
        colleagueNameInput.input = colleagueName
    }
}