package com.babic.filip.kotlinandroidtalks.di.module

import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.presentation.NoteInputPresenter
import com.babic.filip.kotlinandroidtalks.presentation.NotesPresenter
import com.babic.filip.kotlinandroidtalks.ui.note_input.AddNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteInterface
import dagger.Module
import dagger.Provides

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = arrayOf(DatabaseModule::class))
class PresentationModule {

    @Provides fun provideNotesPresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): NoteInterface.Presenter = NotesPresenter(databaseManager, firebaseManager)

    @Provides fun provideAddNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): AddNoteInterface.Presenter = NoteInputPresenter(databaseManager, firebaseManager)
}