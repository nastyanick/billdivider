package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.main.MainActivity
import com.nastynick.billdivider.presentation.main.MainContract
import com.nastynick.billdivider.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun provideRootView(activity: MainActivity): MainContract.View

    @Binds
    abstract fun provideRootPresenter(presenter: MainPresenter): MainContract.Presenter
}