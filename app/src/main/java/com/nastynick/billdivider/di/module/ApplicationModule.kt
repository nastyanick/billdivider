package com.nastynick.billdivider.di.module

import android.app.Application
import android.content.Context
import com.nastynick.billdivider.DatabaseManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideDatabaseManager() = DatabaseManager()
}