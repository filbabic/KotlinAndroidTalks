package com.babic.filip.kotlinandroidtalks.data_objects

import java.io.Serializable

/**
 * Created by Filip Babic @cobe
 */

data class KotlinNote(val title: String = "",
                      val text: String = "",
                      val timestamp: String = "",
                      var position: Int = -1) : Serializable