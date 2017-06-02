package com.babic.filip.kotlinandroidtalks.common.helper_functions

import android.app.DialogFragment
import android.app.FragmentManager
import com.babic.filip.kotlinandroidtalks.common.constants.KEY_NOTE
import com.babic.filip.kotlinandroidtalks.common.extensions.addArguments
import com.babic.filip.kotlinandroidtalks.common.extensions.logSelf
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.ui.note_input.bills.BillsNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.regular.RegularNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.ShoppingNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.work.WorkNoteDialog

/**
 * Created by Filip Babic @cobe
 */

fun showNoteDialog(fragmentManager: FragmentManager, note: Note) {
    val dialog = RegularNoteDialog()

    createAndShowDialog(dialog, fragmentManager, note)
}

fun showWorkDialog(fragmentManager: FragmentManager, note: Note) {
    val dialog = WorkNoteDialog()

    createAndShowDialog(dialog, fragmentManager, note)
}

fun showShoppingDialog(fragmentManager: FragmentManager, note: Note) {
    val dialog = ShoppingNoteDialog()

    createAndShowDialog(dialog, fragmentManager, note)
}

fun showBillsDialog(fragmentManager: FragmentManager, note: Note) {
    val dialog = BillsNoteDialog()

    createAndShowDialog(dialog, fragmentManager, note)
}

private fun createAndShowDialog(dialog: DialogFragment, fragmentManager: FragmentManager, note: Note) = with(dialog) {
    addArguments { putSerializable(KEY_NOTE, note) }
    display(fragmentManager)
}

private fun DialogFragment.display(fragmentManager: FragmentManager) {
    try {
        show(fragmentManager, null)
    } catch (e: Throwable) {
        e.logSelf()
    }
}