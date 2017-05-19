package com.babic.filip.kotlinandroidtalks.data_objects

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Filip Babic @cobe
 */

open class RealmKotlinNote(var title: String = "",
                           var text: String = "",
                           @PrimaryKey var timestamp: String = "",
                           var position: Int = -1) : RealmObject()