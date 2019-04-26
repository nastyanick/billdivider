package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.main.MainContract
import com.nastynick.billdivider.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideRootPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}