package com.babic.filip.kotlinandroidtalks.common.extensions

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.data_objects.RealmKotlinNote
import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery

/**
 * Created by Filip Babic @cobe
 */

fun <T : RealmModel> Realm.getCopies(query: Realm.() -> RealmQuery<T>): List<T> = copyFromRealm(query().findAll())

fun <T : RealmModel> Realm.getFirst(query: Realm.() -> RealmQuery<T>): T = copyFromRealm(query().findFirst())

fun <T : RealmModel> Realm.saveObject(model: T) {
    beginTransaction()
    copyToRealmOrUpdate(model)
    commitTransaction()
}

fun <T : RealmModel> Realm.deleteObject(query: Realm.() -> RealmQuery<T>) {
    val savedModel: T? = query().findFirst()

    savedModel?.let { remove(it) }
}

private fun <T : RealmModel> Realm.remove(model: T) {
    beginTransaction()
    delete(model::class.java)
    commitTransaction()
}


fun RealmKotlinNote.toNote() = KotlinNote(title, text, timestamp, position)

fun KotlinNote.toRealmNote() = RealmKotlinNote(title, text, timestamp, -1)
