package com.babic.filip.kotlinandroidtalks.common.extensions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

/**
 * Created by Filip Babic @cobe
 */

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

inline fun <reified T : View> Activity.find(@IdRes id: Int): T = findViewById(id) as T