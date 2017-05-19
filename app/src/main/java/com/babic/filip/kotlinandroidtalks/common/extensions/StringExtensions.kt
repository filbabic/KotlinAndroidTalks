package com.babic.filip.kotlinandroidtalks.common.extensions

/**
 * Created by Filip Babic @cobe
 */


fun String?.isValid() = this != null && !isEmpty() && !trim().isEmpty()

fun Collection<String?>.isValid(): Boolean {
    forEach { if (!it.isValid()) return false }

    return true
}