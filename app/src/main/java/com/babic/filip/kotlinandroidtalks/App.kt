package com.babic.filip.kotlinandroidtalks

import android.app.Application
import com.babic.filip.kotlinandroidtalks.di.component.AppComponent
import com.babic.filip.kotlinandroidtalks.di.component.DaggerAppComponent
import com.babic.filip.kotlinandroidtalks.di.module.AppModule

/**
 * Created by Filip Babic @cobe
 */
class App : Application() {

    companion object {

        private lateinit var component: AppComponent
        private lateinit var app: App

        fun component() = component
        fun app() = app
    }

    override fun onCreate() {
        super.onCreate()

        app = this
        component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        component.inject(this)
    }
}