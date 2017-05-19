package com.babic.filip.kotlinandroidtalks.di.component

import com.babic.filip.kotlinandroidtalks.App
import com.babic.filip.kotlinandroidtalks.di.module.PresentationModule
import com.babic.filip.kotlinandroidtalks.di.scope.AppScope
import com.babic.filip.kotlinandroidtalks.ui.add.AddNoteActivity
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

    fun inject(addNoteActivity: AddNoteActivity)
}