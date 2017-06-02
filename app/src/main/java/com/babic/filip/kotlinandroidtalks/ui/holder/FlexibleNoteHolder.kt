package com.babic.filip.kotlinandroidtalks.ui.holder

import com.babic.filip.flexibleadapter.FlexibleHolder
import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */
interface FlexibleNoteHolder : FlexibleHolder {

    var longClick: ((Note) -> Unit)?
    var onClick: ((Note) -> Unit)?

    fun getId(): String

    fun setOnLongClickAction(longClick: (Note) -> Unit) {
        this.longClick = longClick
    }

    fun setOnClickAction(onClick: (Note) -> Unit) {
        this.onClick = onClick
    }
}