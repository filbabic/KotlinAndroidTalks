package com.babic.filip.kotlinandroidtalks.di.module

import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.presentation.AddNotePresenter
import com.babic.filip.kotlinandroidtalks.presentation.NotesPresenter
import com.babic.filip.kotlinandroidtalks.ui.add.AddNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteInterface
import dagger.Module
import dagger.Provides

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = arrayOf(DatabaseModule::class))
class PresentationModule {

    @Provides fun provideNotesPresenter(databaseManager: DatabaseManager): NoteInterface.Presenter = NotesPresenter(databaseManager)

    @Provides fun provideAddNotePresenter(databaseManager: DatabaseManager): AddNoteInterface.Presenter = AddNotePresenter(databaseManager)
}