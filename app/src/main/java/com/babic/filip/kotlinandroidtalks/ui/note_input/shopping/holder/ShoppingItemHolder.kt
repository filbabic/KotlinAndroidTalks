package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder

import android.view.View
import android.widget.EditText
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.find
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.data_objects.ShoppingItem
import com.babic.filip.kotlinandroidtalks.ui.custom.SimpleTextWatcher

/**
 * Created by Filip Babic @cobe
 */
class ShoppingItemHolder(private val item: ShoppingItem) : FlexibleShoppingHolder {

    override fun getShoppingItem() = item.shoppingItem

    override fun getLayout() = R.layout.item_shopping

    override fun displayView(rootView: View) {
        val shoppingInput: EditText = rootView.find(R.id.shoppingInput)

        shoppingInput.input = item.shoppingItem

        shoppingInput.addTextChangedListener(SimpleTextWatcher({ item.shoppingItem = it }))
    }

    override fun recycle() {}
}