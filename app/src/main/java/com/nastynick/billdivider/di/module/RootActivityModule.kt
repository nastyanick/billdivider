package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.root.view.RootActivity
import com.nastynick.billdivider.root.view.RootView
import dagger.Module
import dagger.Provides

@Module
class RootActivityModule {

    @Provides
    fun provideRootView(activity: RootActivity): RootView {
        return activity
    }
}