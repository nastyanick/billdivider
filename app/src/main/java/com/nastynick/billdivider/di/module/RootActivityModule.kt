package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.root.RootActivity
import com.nastynick.billdivider.presentation.root.RootView
import dagger.Binds
import dagger.Module

@Module
abstract class RootActivityModule {

    @Binds
    abstract fun provideRootView(activity: RootActivity): RootView
}