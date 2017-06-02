package com.babic.filip.kotlinandroidtalks.ui.notes

import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.base.BasePresenter
import com.babic.filip.kotlinandroidtalks.ui.base.BaseView
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder

/**
 * Created by Filip Babic @cobe
 */
interface NoteInterface {

    interface View : BaseView {

        fun showDeleteNoteDialog(onDeleteClick: () -> Unit)

        fun showNotes(notes: List<FlexibleNoteHolder>)

        fun deleteNote(position: String)

        fun showNoteCategoryPicker()

        fun showFilter()

        fun hideFilter()

        fun showWorkNoteDialog(note: Note)

        fun showRegularNoteDialog(note: Note)

        fun showBillsNoteDialog(note: Note)

        fun showShoppingNoteDialog(note: Note)
    }

    interface Presenter : BasePresenter<View> {

        fun getNotes()

        fun onAddNoteClick()

        fun onFilterClick()

        fun onFilterChanged(filter: String)

        fun onCategoryPicked(category: String)
    }
}