package com.babic.filip.kotlinandroidtalks.ui.note_input

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.common.extensions.toast
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import kotlinx.android.synthetic.main.activity_note_input.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class NoteInputActivity : AppCompatActivity(), AddNoteInterface.View {

    @Inject lateinit var presenter: AddNoteInterface.Presenter

    companion object {
        fun launchIntent(from: Context, note: KotlinNote? = null): Intent {
            val intent = Intent(from, NoteInputActivity::class.java)
            intent.putExtra(KEY_NOTE, note)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_input)
        injectDependencies()

        doneAction.setOnClickListener { presenter.onDoneClick(noteTitleInput.input(), noteTextInput.input()) }

        presenter.checkNote(intent.getSerializableExtra(KEY_NOTE) as? KotlinNote ?: KotlinNote())
    }

    private fun injectDependencies() {
        App.component().inject(this)
        presenter.setView(view = this)
    }

    override fun showText(text: String) = noteTextInput.setText(text)
    override fun showTitle(title: String) = noteTitleInput.setText(title)

    override fun showSaveNoteError() = toast(message = getString(R.string.save_note_error))

    override fun navigateBack() = finish()
}