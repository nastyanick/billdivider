package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.bills.BillsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(BillsFragmentModule::class))
    abstract fun bindBillsFragment(): BillsFragment
}