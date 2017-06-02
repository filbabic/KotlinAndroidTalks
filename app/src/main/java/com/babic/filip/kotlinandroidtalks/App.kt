package com.babic.filip.kotlinandroidtalks

import android.app.Application
import android.support.multidex.MultiDex
import com.babic.filip.kotlinandroidtalks.di.component.AppComponent
import com.babic.filip.kotlinandroidtalks.di.component.DaggerAppComponent
import com.babic.filip.kotlinandroidtalks.di.module.AppModule

/**
 * Created by Filip Babic @cobe
 */
class App : Application() {

    companion object {

        lateinit var app: App
            private set

        val component: AppComponent by lazy {
            DaggerAppComponent.builder()
                    .appModule(AppModule(app))
                    .build()
        }
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)

        app = this

        component.inject(this)
    }
}