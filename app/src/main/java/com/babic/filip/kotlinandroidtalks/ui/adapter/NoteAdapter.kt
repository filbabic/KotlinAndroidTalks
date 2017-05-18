package com.babic.filip.kotlinandroidtalks.ui.adapter

import com.babic.filip.flexibleadapter.FlexibleAdapter
import com.babic.filip.kotlinandroidtalks.ui.holder.FlexibleNoteHolder

/**
 * Created by Filip Babic @cobe
 */
class NoteAdapter : FlexibleAdapter<FlexibleNoteHolder>() {

    fun deleteNote(position : Int){
        flexibleItems.removeAt(position)
        notifyDataSetChanged()
    }
}