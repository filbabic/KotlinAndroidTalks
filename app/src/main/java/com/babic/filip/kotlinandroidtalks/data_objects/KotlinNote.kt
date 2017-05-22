package com.babic.filip.kotlinandroidtalks.data_objects

import java.io.Serializable

/**
 * Created by Filip Babic @cobe
 */

data class KotlinNote(val id: String = "",
                      val title: String = "",
                      val text: String = "") : Serializable