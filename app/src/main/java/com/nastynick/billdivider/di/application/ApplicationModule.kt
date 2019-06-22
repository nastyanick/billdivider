package com.nastynick.billdivider.di.application

import android.app.Application
import com.nastynick.billdivider.data.schedulers.AppSchedulers
import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(val application: Application) {

    @ApplicationScope
    @Provides
    fun provideApplication(): Application = this.application

    @ApplicationScope
    @Provides
    fun provideSchedulers(): SchedulersProvider = AppSchedulers()
}