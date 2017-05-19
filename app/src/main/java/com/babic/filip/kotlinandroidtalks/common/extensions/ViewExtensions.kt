package com.babic.filip.kotlinandroidtalks.common.extensions

import android.support.annotation.IdRes
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.babic.filip.kotlinandroidtalks.common.constants.ANIM_DURATION

/**
 * Created by Filip Babic @cobe
 */

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

fun TextView.input() = text.toString()

fun View.animateFadeOut(duration: Long = ANIM_DURATION, setGone: Boolean = true, endAction: () -> Unit = {}) {
    animate().alpha(0f)
            .setDuration(duration)
            .withEndAction {
                endAction()
                visibility = if (setGone) View.GONE else View.VISIBLE
            }
            .start()
}

fun View.animateFadeIn(duration: Long = ANIM_DURATION) {
    visibility = View.VISIBLE

    animate().alpha(1f).setDuration(duration).start()
}

fun ImageView.animateImageChange(duration: Long = ANIM_DURATION, newImage: Int) {
    animateFadeOut(duration = duration, setGone = false, endAction = {
        setImageResource(newImage)

        animateFadeIn(duration = duration)
    })
}