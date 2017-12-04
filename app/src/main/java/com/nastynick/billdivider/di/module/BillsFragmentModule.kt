package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.bills.BillsContract
import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.bills.BillsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class BillsFragmentModule {

    @Binds
    abstract fun provideBillView(billsFragment: BillsFragment): BillsContract.View

    @Binds
    abstract fun provideBillPresenter(billsPresenter: BillsPresenter): BillsContract.Presenter
}