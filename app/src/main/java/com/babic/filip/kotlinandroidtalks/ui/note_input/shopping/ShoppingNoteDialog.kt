package com.babic.filip.kotlinandroidtalks.ui.note_input.shopping

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.R
import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.common.extensions.input
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.base.BaseNoteInputDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.adapter.ShoppingItemAdapter
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.AddShoppingItemHolder
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.holder.FlexibleShoppingHolder
import kotlinx.android.synthetic.main.dialog_shopping_note.*
import kotlinx.android.synthetic.main.layout_note_input.*
import javax.inject.Inject

/**
 * Created by Filip Babic @cobe
 */
class ShoppingNoteDialog : BaseNoteInputDialog(), ShoppingNoteInterface.View {

    @Inject lateinit var presenter: ShoppingNoteInterface.Presenter

    private val adapter = ShoppingItemAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.dialog_shopping_note, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkData()
    }

    override fun initUI() {
        doneAction.setOnClickListener {
            val items = adapter.getShoppingItems()

            val note = Note(title = titleInput.input, text = textInput.input, category = Category.Shopping(items = items))
            presenter.onDoneClick(noteInput = note)
        }

        initList()
    }

    override fun injectDependencies() {
        App.component.inject(this)
        presenter.setView(this)
    }

    private fun checkData() {
        val note = arguments?.getSerializable(KEY_NOTE) as? Note ?: Note()
        presenter.checkNoteData(note)
    }

    private fun initList() {
        shoppingList.layoutManager = LinearLayoutManager(activity)
        shoppingList.itemAnimator = DefaultItemAnimator()
        shoppingList.adapter = adapter
    }

    override fun addShoppingItems(holders: List<FlexibleShoppingHolder>) = adapter.setItems(holders)
    override fun addNewShoppingItemField() = adapter.addShoppingItem()
    override fun setAddNewShoppingItem(newShoppingItem: AddShoppingItemHolder) = adapter.setAddNewShoppingItem(newShoppingItem)
}