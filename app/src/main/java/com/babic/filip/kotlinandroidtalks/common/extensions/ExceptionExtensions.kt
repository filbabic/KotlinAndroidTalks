package com.babic.filip.kotlinandroidtalks.common.extensions

/**
 * Created by Filip Babic @cobe
 */


fun Throwable?.logSelf() {
    this?.printStackTrace()
}