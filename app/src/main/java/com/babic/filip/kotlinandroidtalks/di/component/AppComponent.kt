package com.babic.filip.kotlinandroidtalks.di.component

import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.di.module.PresentationModule
import com.babic.filip.kotlinandroidtalks.di.scope.AppScope
import com.babic.filip.kotlinandroidtalks.ui.note_input.bills.BillsNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.regular.RegularNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.ShoppingNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.note_input.work.WorkNoteDialog
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteActivity
import dagger.Component

/**
 * Created by Filip Babic @cobe
 */

@AppScope
@Component(modules = arrayOf(PresentationModule::class))
interface AppComponent {

    fun inject(app: App)

    fun inject(noteActivity: NoteActivity)

    fun inject(regularNoteDialog: RegularNoteDialog)

    fun inject(billsNoteDialog: BillsNoteDialog)

    fun inject(workNoteDialog: WorkNoteDialog)

    fun inject(shoppingNoteDialog: ShoppingNoteDialog)
}