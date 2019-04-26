package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.bills.BillsContract
import com.nastynick.billdivider.presentation.bills.BillsPresenter
import dagger.Module
import dagger.Provides

@Module
class BillsFragmentModule {

    @Provides
    fun providePresenter(presenter: BillsPresenter): BillsContract.Presenter = presenter
}