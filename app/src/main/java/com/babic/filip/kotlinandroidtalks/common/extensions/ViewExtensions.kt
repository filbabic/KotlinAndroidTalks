package com.babic.filip.kotlinandroidtalks.common.extensions

import android.support.annotation.IdRes
import android.view.View
import android.widget.TextView

/**
 * Created by Filip Babic @cobe
 */

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

fun TextView.input() = text.toString()