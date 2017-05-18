package com.babic.filip.kotlinandroidtalks.data_objects

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey

/**
 * Created by Filip Babic @cobe
 */
data class KotlinNote(@PrimaryKey val title: String = "",
                      val text: String = "",
                      val timestamp: String = "",
                      var position: Int = -1) : RealmModel