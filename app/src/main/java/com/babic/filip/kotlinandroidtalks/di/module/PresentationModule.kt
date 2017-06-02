package com.babic.filip.kotlinandroidtalks.di.module

import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.firebase.FirebaseManager
import com.babic.filip.kotlinandroidtalks.presentation.*
import com.babic.filip.kotlinandroidtalks.ui.note_input.bills.BillsNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.regular.RegularNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.shopping.ShoppingNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.note_input.work.WorkNoteInterface
import com.babic.filip.kotlinandroidtalks.ui.notes.NoteInterface
import dagger.Module
import dagger.Provides

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = arrayOf(DatabaseModule::class))
class PresentationModule {

    @Provides fun provideNotesPresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): NoteInterface.Presenter = NotesPresenter(databaseManager, firebaseManager)

    @Provides fun provideRegularNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): RegularNoteInterface.Presenter = RegularNotePresenter(databaseManager, firebaseManager)

    @Provides fun provideWorkNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): WorkNoteInterface.Presenter = WorkNotePresenter(databaseManager, firebaseManager)

    @Provides fun provideBillNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): BillsNoteInterface.Presenter = BillNotePresenter(databaseManager, firebaseManager)

    @Provides fun provideShoppingNotePresenter(databaseManager: DatabaseManager, firebaseManager: FirebaseManager): ShoppingNoteInterface.Presenter = ShoppingNotePresenter(databaseManager, firebaseManager)
}