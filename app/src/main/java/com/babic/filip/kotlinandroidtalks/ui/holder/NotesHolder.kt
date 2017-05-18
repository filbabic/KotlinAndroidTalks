package com.babic.filip.kotlinandroidtalks.ui.holder

import android.view.View
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.find
import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote

/**
 * Created by Filip Babic @cobe
 */
class NotesHolder(private val note: KotlinNote) : FlexibleNoteHolder {

    private var longClick: ((KotlinNote) -> Unit)? = null
    private var onClick: ((KotlinNote) -> Unit)? = null

    override fun getLayout() = R.layout.item_note

    override fun displayView(rootView: View) {
        initRoot(rootView)
    }

    private fun initRoot(rootView: View) {
        val root: View = rootView.find(id = R.id.noteRoot)

        root.setOnClickListener { onClick?.invoke(note) }

        root.setOnLongClickListener {
            longClick?.invoke(note)
            false
        }
    }

    fun setOnLongClickAction(longClick: (KotlinNote) -> Unit) {
        this.longClick = longClick
    }

    fun setOnClickAction(onClick: (KotlinNote) -> Unit) {
        this.onClick = onClick
    }

    override fun setPosition(position: Int) {
        note.position = position
    }

    override fun recycle() {}
}