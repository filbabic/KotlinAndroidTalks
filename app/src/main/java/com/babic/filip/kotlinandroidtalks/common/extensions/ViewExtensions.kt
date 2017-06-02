package com.babic.filip.kotlinandroidtalks.common.extensions

import android.support.annotation.IdRes
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import com.babic.filip.kotlinandroidtalks.common.constants.ANIM_DURATION
import com.babic.filip.kotlinandroidtalks.common.constants.ANIM_DURATION_MEDIUM
import com.babic.filip.kotlinandroidtalks.common.constants.ANIM_DURATION_MEDIUM_LONG
import com.babic.filip.kotlinandroidtalks.common.helper_functions.centerView
import com.babic.filip.kotlinandroidtalks.common.helper_functions.setViewBottom
import com.imangazaliev.circlemenu.CircleMenu

/**
 * Created by Filip Babic @cobe
 */

inline fun <reified T : View> View.find(@IdRes id: Int): T = findViewById(id) as T

var TextView.input: String
    get() = text.toString()
    set(value) {
        text = value
    }

fun View.animateFadeOut(duration: Long = ANIM_DURATION, setGone: Boolean = true, endAction: () -> Unit = {}) {
    animate().alpha(0f)
            .setDuration(duration)
            .withEndAction {
                endAction()
                visibility = if (setGone) View.GONE else View.VISIBLE
            }.start()
}

fun View.animateFadeIn(duration: Long = ANIM_DURATION, endAction: () -> Unit = {}) {
    visibility = View.VISIBLE

    animate().alpha(1f).setDuration(duration).withEndAction(endAction).start()
}

fun ImageView.animateImageChange(duration: Long = ANIM_DURATION, newImage: Int) {
    animateFadeOut(duration = duration, setGone = false, endAction = {
        setImageResource(newImage)

        animateFadeIn(duration = duration)
    })
}

fun View.animateToCategoryPicker(categoryPicker: CircleMenu, duration: Long = ANIM_DURATION_MEDIUM, root: View, onPickAction: (String) -> Unit) {
    val relativeX = -(root.width / 2 - (width / 2) - paddingRight).toFloat()
    val relativeY = -(root.height / 2 - (height / 2) - paddingBottom).toFloat()

    val translation = animate()
            .translationX(relativeX)
            .translationY(relativeY)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setDuration(duration)

    translation.withEndAction {
        centerView(this) // we center it, and reset the relative translations

        categoryPicker.animateFadeIn(duration, endAction = { categoryPicker.toggle() })
    }

    translation.start()

    val reverseTranslation: (String) -> Unit = {
        animate().translationX((-relativeX))
                .translationY((-relativeY))
                .setInterpolator(AccelerateDecelerateInterpolator())
                .setDuration(duration)
                .withEndAction {
                    setViewBottom(this)
                    categoryPicker.setStateUpdateListener(null)
                    categoryPicker.setOnItemClickListener(null)
                    onPickAction(it)
                }
    }

    val onCategoryPickAction: (String) -> Unit = {
        categoryPicker.animateFadeOut(duration, setGone = true, endAction = {
            reverseTranslation(it)
        })
    }

    categoryPicker.setOnItemClickListener {
        it.postDelayed({ onCategoryPickAction(it.tag.toString()) }, ANIM_DURATION_MEDIUM_LONG)
    }

    categoryPicker.setStateUpdateListener(object : CircleMenu.OnStateUpdateListener {
        override fun onMenuCollapsed() = onCategoryPickAction("")
        override fun onMenuExpanded() {}
    })
}