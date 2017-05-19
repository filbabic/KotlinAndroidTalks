package com.babic.filip.kotlinandroidtalks.ui.add

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import kotlinx.android.synthetic.main.activity_add_note.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class AddNoteActivity : AppCompatActivity(), AddNoteInterface.View {

    @Inject lateinit var presenter: AddNoteInterface.Presenter

    companion object {
        fun launchIntent(from: Context): Intent = Intent(from, AddNoteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        injectDependencies()

        doneAction.setOnClickListener { presenter.onDoneClick(noteTitleInput.input(), noteTextInput.input()) }
    }

    private fun injectDependencies() {
        App.component().inject(this)
        presenter.setView(view = this)
    }

    override fun navigateBack() = finish()
}