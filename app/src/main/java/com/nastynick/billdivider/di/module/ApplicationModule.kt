package com.nastynick.billdivider.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context = application
}