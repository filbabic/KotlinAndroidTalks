package com.babic.filip.kotlinandroidtalks.ui.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.addNegativeAction
import com.babic.filip.kotlinandroidtalks.common.extensions.addPositiveAction
import com.babic.filip.kotlinandroidtalks.common.extensions.createDialog
import com.babic.filip.kotlinandroidtalks.common.extensions.display
import com.babic.filip.kotlinandroidtalks.ui.adapter.NoteAdapter
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder
import kotlinx.android.synthetic.main.activity_notes.*

/**
 * Created by Filip Babic @cobe
 */
class NoteActivity : AppCompatActivity(), NoteInterface.View {

    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        initNotes()
    }

    private fun initNotes() {
        notesList.adapter = noteAdapter
        notesList.itemAnimator = DefaultItemAnimator()
        notesList.layoutManager = LinearLayoutManager(this)
    }

    override fun showNotes(notes: List<FlexibleNoteHolder>) = noteAdapter.setItems(notes)

    override fun deleteNote(position: Int) = noteAdapter.deleteNote(position)

    override fun showDeleteNoteDialog(onDeleteClick: () -> Unit) {
        createDialog(title = getString(R.string.delete_note_title), message = getString(R.string.delete_note_message))
                .addNegativeAction(text = getString(R.string.cancel_action))
                .addPositiveAction(text = getString(R.string.delete_action), action = onDeleteClick)
                .display()
    }

    override fun navigateBack() = finish()
}