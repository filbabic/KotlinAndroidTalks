package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.adapter

import com.babic.filip.flexibleadapter.FlexibleAdapter
import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.ShoppingItem
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.AddShoppingItemHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.FlexibleShoppingHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.ShoppingItemHolder

/**
 * Created by Filip Babic @cobe
 */
class ShoppingItemAdapter : FlexibleAdapter<FlexibleShoppingHolder>() {

    fun getShoppingItems() = flexibleItems.map { it.getShoppingItem() }.filter { it.isValid() }

    fun addShoppingItem() = with(flexibleItems) {
        val insertIndex = lastIndex - 1
        add(insertIndex, ShoppingItemHolder(ShoppingItem()))

        notifyItemInserted(insertIndex)
    }

    fun setAddNewShoppingItem(newShoppingItem: AddShoppingItemHolder) {
        flexibleItems.clear()
        flexibleItems.add(newShoppingItem)
        notifyDataSetChanged()
    }
}