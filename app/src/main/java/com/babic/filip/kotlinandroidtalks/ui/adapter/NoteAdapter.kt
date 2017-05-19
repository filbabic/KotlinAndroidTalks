package com.babic.filip.kotlinandroidtalks.ui.adapter

import com.babic.filip.flexibleadapter.FlexibleAdapter
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder

/**
 * Created by Filip Babic @cobe
 */
class NoteAdapter : FlexibleAdapter<FlexibleNoteHolder>() {

    fun deleteNote(position: Int) {
        flexibleItems.removeAt(position)
        resetPositions(flexibleItems)

        notifyDataSetChanged()
    }

    override fun setItems(dataSource: List<FlexibleNoteHolder>) {
        resetPositions(dataSource)

        flexibleItems.clear()
        flexibleItems.addAll(dataSource)
        notifyDataSetChanged()
    }

    private fun resetPositions(dataSource: List<FlexibleNoteHolder>) = dataSource.forEachIndexed { index, item -> item.setPosition(index) }
}