package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder

import android.view.View
import android.widget.Button
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.extensions.find

/**
 * Created by Filip Babic @cobe
 */
class AddShoppingItemHolder : FlexibleShoppingHolder {

    private var onClick: (() -> Unit)? = null

    override fun getShoppingItem() = ""
    override fun getLayout() = R.layout.item_add_shopping

    override fun displayView(rootView: View) {
        val addItem: Button = rootView.find(R.id.addShoppingItem)

        addItem.setOnClickListener { onClick?.invoke() }
    }

    fun addOnClickAction(onClick: () -> Unit) {
        this.onClick = onClick
    }

    override fun recycle() {}
}