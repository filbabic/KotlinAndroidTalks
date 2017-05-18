package com.babic.filip.kotlinandroidtalks.di.module

import android.content.Context
import com.babic.filip.kotlinandroidtalks.database.DatabaseManager
import com.babic.filip.kotlinandroidtalks.database.DatabaseManagerImpl
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by Filip Babic @cobe
 */

@Module(includes = arrayOf(AppModule::class))
class DatabaseModule {

    @Provides fun provideConfiguration(context: Context): RealmConfiguration {
        Realm.init(context)

        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)

        return config
    }

    @Provides fun provideRealm(realmConfiguration: RealmConfiguration): Realm = Realm.getInstance(realmConfiguration)

    @Provides fun provideDatabaseManager(realm: Realm): DatabaseManager = DatabaseManagerImpl(realm)
}