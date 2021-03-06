package com.babic.filip.kotlinandroidtalks.ui.holder

import android.view.View
import android.widget.TextView
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.find
import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
class RegularNoteHolder(private val note: Note) : FlexibleNoteHolder {

    override var longClick: ((Note) -> Unit)? = null
    override var onClick: ((Note) -> Unit)? = null

    override fun getLayout() = R.layout.item_note

    override fun displayView(rootView: View) {
        initRoot(rootView)
        initNote(rootView)
    }

    private fun initNote(rootView: View) {
        val noteTitle: TextView = rootView.find(id = R.id.noteTitle)
        val noteText: TextView = rootView.find(id = R.id.noteText)

        noteTitle.text = note.title
        noteText.text = note.text
    }

    private fun initRoot(rootView: View) {
        val root: View = rootView.find(id = R.id.noteRoot)

        root.setOnClickListener { onClick?.invoke(note) }

        root.setOnLongClickListener {
            longClick?.invoke(note)
            false
        }
    }

    override fun getId() = note.id

    override fun recycle() {}
}