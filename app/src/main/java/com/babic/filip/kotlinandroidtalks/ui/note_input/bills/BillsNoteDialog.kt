package com.babic.filip.kotlinandroidtalks.ui.note_input.bills

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
import kotlinx.android.synthetic.main.dialog_bills_note.*
import kotlinx.android.synthetic.main.layout_note_input.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class BillsNoteDialog : BaseNoteInputDialog(), BillsNoteInterface.View {

    @Inject lateinit var presenter: BillsNoteInterface.Presenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.dialog_bills_note, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkData()
    }

    override fun initUI() {
        doneAction.setOnClickListener {
            val note = Note(title = titleInput.input, text = textInput.input, category = Category.Bills(billInput.input.toFloat()))
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

    override fun showBillAmount(amount: String) {
        billInput.input = amount
    }
}