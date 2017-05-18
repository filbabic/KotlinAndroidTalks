package com.babic.filip.kotlinandroidtalks.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Filip Babic @cobe
 */

@Module
class AppModule(private val context: Context) {

    @Provides fun provideContext() = context
}