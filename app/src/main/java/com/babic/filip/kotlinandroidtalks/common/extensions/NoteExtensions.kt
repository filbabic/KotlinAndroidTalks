package com.babic.filip.kotlinandroidtalks.common.extensions

import com.babic.filip.kotlinandroidtalks.common.constants.CATEGORY_BILLS
import com.babic.filip.kotlinandroidtalks.common.constants.CATEGORY_SHOPPING
import com.babic.filip.kotlinandroidtalks.common.constants.CATEGORY_WORK
import com.babic.filip.kotlinandroidtalks.common.constants.Category
import com.babic.filip.kotlinandroidtalks.data_objects.FirebaseNote
import com.babic.filip.kotlinandroidtalks.data_objects.Note
import com.babic.filip.kotlinandroidtalks.data_objects.RealmNote
import com.babic.filip.kotlinandroidtalks.ui.holder.*
import com.google.gson.Gson

/**
 * Created by Filip Babic @cobe
 */

fun RealmNote.toNote() = Note(id, title, text, category = getCategory(categoryName, extraData))

fun Note.toRealmNote() = RealmNote(id, title, text, extraData = Gson().toJson(category), categoryName = categoryName)

fun Note.toFirebaseNote() = FirebaseNote(id, title, text, extraData = Gson().toJson(category), categoryName = categoryName)

fun FirebaseNote.toNote() = Note(id, title, text, categoryName = categoryName, category = getCategory(categoryName, extraData))

fun getCategory(name: String, data: String): Category = when (name) {
    CATEGORY_BILLS -> Gson().fromJson(data, Category.Bills::class.java)
    CATEGORY_SHOPPING -> Gson().fromJson(data, Category.Shopping::class.java)
    CATEGORY_WORK -> Gson().fromJson(data, Category.Work::class.java)
    else -> Category.None()
}

fun emptyCategoryFromName(name: String): Category = when (name) {
    CATEGORY_BILLS -> Category.Bills()
    CATEGORY_SHOPPING -> Category.Shopping()
    CATEGORY_WORK -> Category.Work()
    else -> Category.None()
}

fun Note.toHolder(): FlexibleNoteHolder = when (this.category) {
    is Category.None -> RegularNoteHolder(this)
    is Category.Work -> WorkNoteHolder(this)
    is Category.Shopping -> ShoppingNoteHolder(this)
    is Category.Bills -> BillNoteHolder(this)
}