package com.babic.filip.kotlinandroidtalks.ui.base

/**
 * Created by Filip Babic @cobe
 */
interface BasePresenter<in T : BaseView> {

    fun setView(view: T)

    fun onBackClick() {}
}