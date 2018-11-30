package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.main.MainActivity
import com.nastynick.billdivider.presentation.main.MainContract
import com.nastynick.billdivider.presentation.main.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: MainActivity) {

    @Provides
    fun provideRootView(): MainContract.View = activity

    @Provides
    fun provideRootPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}