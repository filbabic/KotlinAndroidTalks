package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping

import com.babic.filip.kotlinandroidtalks.ui.base.NoteInputInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.AddShoppingItemHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.FlexibleShoppingHolder

/**
 * Created by Filip Babic @cobe
 */
interface ShoppingNoteInterface {

    interface View : NoteInputInterface.View {

        fun setAddNewShoppingItem(newShoppingItem: AddShoppingItemHolder)

        fun addShoppingItems(holders: List<FlexibleShoppingHolder>)

        fun addNewShoppingItemField()
    }

    interface Presenter : NoteInputInterface.Presenter<View>
}