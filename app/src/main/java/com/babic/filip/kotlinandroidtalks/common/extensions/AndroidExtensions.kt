package com.babic.filip.kotlinandroidtalks.common.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * Created by Filip Babic @cobe
 */


fun Context.toast(duration: Int = Toast.LENGTH_SHORT, message: String) = Toast.makeText(this, message, duration).show()

inline fun <reified T : Activity> Context.startNewActivity(addExtras: Intent.() -> Unit) {
    val intent = Intent(this, T::class.java)
    intent.addExtras()
    startActivity(intent)
}

inline fun <reified T : Activity> Context.startNewActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}