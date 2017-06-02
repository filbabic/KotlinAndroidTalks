package com.babic.filip.kotlinandroidtalks.data_objects

import com.babic.filip.kotlinandroidtalks.common.constants.CATEGORY_NONE
import java.io.Serializable

/**
 * Created by Filip Babic @cobe
 */
data class FirebaseNote(val id: String = "", val title: String = "", val text: String = "",
                        val categoryName: String = CATEGORY_NONE,
                        val extraData: String = "") : Serializable