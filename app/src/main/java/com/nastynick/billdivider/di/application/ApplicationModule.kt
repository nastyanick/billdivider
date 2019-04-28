package com.nastynick.billdivider.di.application

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application) {

    @ApplicationScope
    @Provides
    fun provideApplication(): Application = this.application
}