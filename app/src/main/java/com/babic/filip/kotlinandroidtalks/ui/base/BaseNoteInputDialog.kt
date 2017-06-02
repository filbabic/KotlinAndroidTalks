package com.babic.filip.kotlinandroidtalks.ui.base

import android.app.DialogFragment
import android.os.Bundle
import android.view.View
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.common.extensions.toast
import kotlinx.android.synthetic.main.layout_note_input.*

/**
 * Created by Filip Babic @cobe
 */
abstract class BaseNoteInputDialog : DialogFragment(), NoteInputInterface.View {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        injectDependencies()
        initUI()
    }

    abstract fun initUI()

    abstract fun injectDependencies()

    override fun navigateBack() = dismissAllowingStateLoss()

    override fun showSaveNoteError() = toast(message = getString(R.string.save_note_error))

    override fun showText(text: String) {
        textInput.input = text
    }

    override fun showTitle(title: String) {
        titleInput.input = title
    }
}