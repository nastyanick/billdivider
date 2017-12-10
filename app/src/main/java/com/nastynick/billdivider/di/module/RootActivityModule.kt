package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.root.RootActivity
import com.nastynick.billdivider.presentation.root.RootContract
import com.nastynick.billdivider.presentation.root.RootPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class RootActivityModule {

    @Binds
    abstract fun provideRootView(activity: RootActivity): RootContract.View

    @Binds
    abstract fun provideRootPresenter(presenter: RootPresenter): RootContract.Presenter
}