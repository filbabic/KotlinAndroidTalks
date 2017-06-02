package com.babic.filip.kotlinandroidtalks.ui.notes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.*
import com.babic.filip.kotlinandroidtalks.common.helper_functions.*
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.adapter.NoteAdapter
import com.babic.filip.kotlinandroidtalks.ui.custom.SimpleTextWatcher
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder
import kotlinx.android.synthetic.main.activity_notes.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class NoteActivity : AppCompatActivity(), NoteInterface.View {

    @Inject lateinit var presenter: NoteInterface.Presenter

    private val noteAdapter = NoteAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        injectDependencies()
        initUI()
    }

    override fun onStart() {
        super.onStart()
        presenter.getNotes()
    }

    private fun injectDependencies() {
        App.component.inject(this)
        presenter.setView(this)
    }

    private fun initUI() {
        initNotes()

        noteFilter.addTextChangedListener(SimpleTextWatcher { presenter.onFilterChanged(it) })

        addNote.setOnClickListener { presenter.onAddNoteClick() }
        filterAction.setOnClickListener { presenter.onFilterClick() }
    }

    override fun showFilter() {
        filterAction.animateImageChange(newImage = R.drawable.ic_cancel_action)
        toolbarTitle.animateFadeOut()
        noteFilter.animateFadeIn()
    }

    override fun hideFilter() {
        hideKeyboard(from = currentFocus)

        filterAction.animateImageChange(newImage = R.drawable.ic_search_action)
        toolbarTitle.animateFadeIn()
        noteFilter.animateFadeOut()
        noteFilter.text = null
    }

    private fun initNotes() {
        notesList.adapter = noteAdapter
        notesList.itemAnimator = DefaultItemAnimator()
        notesList.layoutManager = LinearLayoutManager(this)
    }

    override fun showNoteCategoryPicker() = addNote.animateToCategoryPicker(categoryPicker, root = rootLayout, onPickAction = { presenter.onCategoryPicked(it) })

    override fun showNotes(notes: List<FlexibleNoteHolder>) = noteAdapter.setItems(notes)

    override fun deleteNote(position: String) = noteAdapter.deleteNote(position)

    override fun showDeleteNoteDialog(onDeleteClick: () -> Unit) {
        createDialog(title = getString(R.string.delete_note_title), message = getString(R.string.delete_note_message))
                .addNegativeAction(text = getString(R.string.cancel_action))
                .addPositiveAction(text = getString(R.string.delete_action), action = onDeleteClick)
                .display()
    }

    override fun showBillsNoteDialog(note: Note) = showBillsDialog(fragmentManager, note)
    override fun showRegularNoteDialog(note: Note) = showNoteDialog(fragmentManager, note)
    override fun showShoppingNoteDialog(note: Note) = showShoppingDialog(fragmentManager, note)
    override fun showWorkNoteDialog(note: Note) = showWorkDialog(fragmentManager, note)

    override fun navigateBack() = finish()
}