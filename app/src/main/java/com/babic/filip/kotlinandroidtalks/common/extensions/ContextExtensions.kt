package com.babic.filip.kotlinandroidtalks.common.extensions

import android.content.Context
import android.support.v7.app.AlertDialog

/**
 * Created by Filip Babic @cobe
 */


fun Context.createDialog(title: String, message: String): AlertDialog.Builder {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(title)
    builder.setMessage(message)

    return builder
}

fun AlertDialog.Builder.addPositiveAction(text: String, action: () -> Unit = {}): AlertDialog.Builder {
    setPositiveButton(text, { dialog, _ ->
        action.invoke()
        dialog.dismiss()
    })

    return this
}

fun AlertDialog.Builder.addNegativeAction(text: String, action: () -> Unit = {}): AlertDialog.Builder {
    setNegativeButton(text, { dialog, _ ->
        action.invoke()
        dialog.dismiss()
    })

    return this
}

fun AlertDialog.Builder.display() {
    try {
        create().show()
    } catch (error: Throwable) {
        error.logSelf()
    }
}