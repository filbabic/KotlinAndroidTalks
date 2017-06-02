package com.babic.filip.kotlinandroidtalks.ui.holder

import android.view.View
import android.widget.TextView
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.extensions.find
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
class WorkNoteHolder(private val note: Note) : FlexibleNoteHolder {

    override var longClick: ((Note) -> Unit)? = null
    override var onClick: ((Note) -> Unit)? = null

    override fun getId() = note.id
    override fun getLayout() = R.layout.item_work_note

    override fun displayView(rootView: View) {
        initRoot(rootView)
        initNote(rootView)
    }

    private fun initRoot(rootView: View) {
        val root: View = rootView.find(id = R.id.noteRoot)

        root.setOnClickListener { onClick?.invoke(note) }

        root.setOnLongClickListener {
            longClick?.invoke(note)
            false
        }
    }

    private fun initNote(rootView: View) {
        val noteTitle: TextView = rootView.find(R.id.noteTitle)
        val noteText: TextView = rootView.find(R.id.noteText)
        val colleagueName: TextView = rootView.find(R.id.colleagueName)

        noteTitle.input = note.title
        noteText.input = note.text

        if (note.category is Category.Work) {
            colleagueName.input = "See ${note.category.colleagueName}"
        }
    }

    override fun recycle() {
    }
}