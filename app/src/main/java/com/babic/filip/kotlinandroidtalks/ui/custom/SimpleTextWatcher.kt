package com.babic.filip.kotlinandroidtalks.ui.custom

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Filip Babic @cobe
 */
class SimpleTextWatcher(private val textListener: (String) -> Unit) : TextWatcher {

    override fun afterTextChanged(text: Editable?) = textListener(text?.toString() ?: "")
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
}