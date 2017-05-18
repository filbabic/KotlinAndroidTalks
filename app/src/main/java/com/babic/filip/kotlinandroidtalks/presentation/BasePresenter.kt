package com.babic.filip.kotlinandroidtalks.presentation

/**
 * Created by Filip Babic @cobe
 */
interface BasePresenter<in T> {

    fun setView(view : T)

    fun onBackClick() {}
}