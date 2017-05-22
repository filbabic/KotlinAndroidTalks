package com.babic.filip.kotlinandroidtalks.ui.adapter

import com.babic.filip.flexibleadapter.FlexibleAdapter
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder

/**
 * Created by Filip Babic @cobe
 */
class NoteAdapter : FlexibleAdapter<FlexibleNoteHolder>() {

    fun deleteNote(id: String) {
        val note = flexibleItems.firstOrNull { it.getId() == id }

        note?.let { removeItem(it) }
    }

    private fun removeItem(item: FlexibleNoteHolder) {
        flexibleItems.remove(item)
        notifyDataSetChanged()
    }

    override fun setItems(dataSource: List<FlexibleNoteHolder>) {
        flexibleItems.clear()
        flexibleItems.addAll(dataSource)
        notifyDataSetChanged()
    }
}