package com.babic.filip.kotlinandroidtalks.common.extensions

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.widget.Toast

/**
 * Created by Filip Babic @cobe
 */


fun Context.toast(duration: Int = Toast.LENGTH_SHORT, message: String) = Toast.makeText(this, message, duration).show()

fun Fragment.toast(duration: Int = Toast.LENGTH_SHORT, message: String) = activity.toast(duration, message)

inline fun Fragment.addArguments(action: Bundle.() -> Unit) {
    val bundle = Bundle()
    bundle.action()

    arguments = bundle
}

fun Context.dpToPixels(dp: Int): Int = (dp * resources.displayMetrics.density).toInt()