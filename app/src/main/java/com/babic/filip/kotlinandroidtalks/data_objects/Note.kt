package com.babic.filip.kotlinandroidtalks.data_objects

import com.babic.filip.kotlinandroidtalks.common.constants.CATEGORY_NONE
import com.babic.filip.kotlinandroidtalks.common.constants.Category
import java.io.Serializable

/**
 * Created by Filip Babic @cobe
 */

data class Note constructor(val id: String = "", val title: String = "", val text: String = "",
                            val categoryName: String = CATEGORY_NONE,
                            val category: Category = Category.None()) : Serializable