package com.babic.filip.kotlinandroidtalks.common.helper_functions

import com.babic.filip.kotlinandroidtalks.common.extensions.isValid
import com.babic.filip.kotlinandroidtalks.data_objects.Note

/**
 * Created by Filip Babic @cobe
 */


fun Note.isValidBody() = with(this) { listOf(text, title, id).isValid() }