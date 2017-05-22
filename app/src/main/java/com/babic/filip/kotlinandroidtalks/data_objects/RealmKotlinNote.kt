package com.babic.filip.kotlinandroidtalks.data_objects

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Filip Babic @cobe
 */

open class RealmKotlinNote(@PrimaryKey var id: String = "",
                           var title: String = "",
                           var text: String = "",
                           var timestamp: String = "",
                           var position: Int = -1) : RealmObject()