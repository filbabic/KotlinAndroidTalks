package com.babic.filip.kotlinandroidtalks.common.extensions

import com.babic.filip.kotlinandroidtalks.data_objects.KotlinNote
import com.babic.filip.kotlinandroidtalks.data_objects.RealmKotlinNote
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmQuery

/**
 * Created by Filip Babic @cobe
 */

fun <T : RealmObject> Realm.getCopies(query: Realm.() -> RealmQuery<T>): List<T> = copyFromRealm(query().findAll())

fun <T : RealmObject> Realm.saveObject(model: T) {
    beginTransaction()
    copyToRealmOrUpdate(model)
    commitTransaction()
}

fun <T : RealmObject> Realm.deleteObject(query: Realm.() -> RealmQuery<T>) {
    val savedModel: T? = query().findFirst()

    savedModel?.let { remove(it) }
}

private fun <T : RealmObject> Realm.remove(model: T) {
    beginTransaction()
    model.deleteFromRealm()
    commitTransaction()
}

fun RealmKotlinNote.toNote() = KotlinNote(title, text, timestamp, position)

fun KotlinNote.toRealmNote() = RealmKotlinNote(title, text, timestamp, -1)
