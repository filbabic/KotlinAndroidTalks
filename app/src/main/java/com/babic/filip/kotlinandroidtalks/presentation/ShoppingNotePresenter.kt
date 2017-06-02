package com.babic.filip.kotlinandroidtalks.presentation

import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.data_objects.ShoppingItem
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.ShoppingNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.AddShoppingItemHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.FlexibleShoppingHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.ShoppingItemHolder

/**
 * Created by Filip Babic @cobe
 */
class ShoppingNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager) : BaseNoteInputPresenter<ShoppingNoteInterface.View>(databaseManager, firebaseManager), ShoppingNoteInterface.Presenter {

    override fun setView(view: ShoppingNoteInterface.View) {
        this.noteView = view
    }

    override fun checkNoteData(noteInput: Note) {
        super.checkNoteData(noteInput)

        val category = noteInput.category

        if (category is Category.Shopping) {
            val newShoppingItem = AddShoppingItemHolder()
            newShoppingItem.addOnClickAction { noteView.addNewShoppingItemField() }

            if (category.items.isNotEmpty()) {
                addShoppingItems(category.items, newShoppingItem)
            } else {
                noteView.setAddNewShoppingItem(newShoppingItem)
            }
        }
    }

    private fun addShoppingItems(items: List<String>, newShoppingItem: FlexibleShoppingHolder) {
        val holders: MutableList<FlexibleShoppingHolder> = items.map { ShoppingItemHolder(ShoppingItem(it)) }.toMutableList()
        holders.add(newShoppingItem)

        noteView.addShoppingItems(holders)
    }
}