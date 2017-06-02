package com.babic.filip.kotlinandroidtalks.common.helper_functions

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.babic.filip.kotlinandroidtalks.common.extensions.dpToPixels

/**
 * Created by Filip Babic @cobe
 */

fun hideKeyboard(from: View) {
    val inputManager = from.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager

    inputManager?.hideSoftInputFromWindow(from.windowToken, 0)
}

fun centerView(view: View) {
    val buttonParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    buttonParams.gravity = Gravity.CENTER

    view.layoutParams = buttonParams
    view.translationX = 0f
    view.translationY = 0f
}

fun setViewBottom(view: View) {
    val buttonParams = CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    buttonParams.gravity = Gravity.BOTTOM or Gravity.END
    buttonParams.rightMargin = view.context.dpToPixels(16)
    buttonParams.bottomMargin = view.context.dpToPixels(16)

    view.layoutParams = buttonParams
    view.translationX = 0f
    view.translationY = 0f
}