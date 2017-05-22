package com.babic.filip.kotlinandroidtalks.common.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by Filip Babic @cobe
 */


fun Context.toast(duration: Int = Toast.LENGTH_SHORT, message: String) = Toast.makeText(this, message, duration).show()