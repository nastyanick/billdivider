package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.bills.BillsContract
import com.nastynick.billdivider.bills.presenter.BillsPresenter
import com.nastynick.billdivider.root.view.RootActivity
import com.nastynick.billdivider.root.view.RootView
import dagger.Binds
import dagger.Module

@Module
abstract class RootActivityModule {

    @Binds
    abstract fun provideRootView(activity: RootActivity): RootView

    @Binds
    abstract fun providePresenter(presenter: BillsPresenter): BillsContract.Presenter
}