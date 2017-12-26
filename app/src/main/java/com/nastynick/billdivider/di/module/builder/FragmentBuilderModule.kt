package com.nastynick.billdivider.di.module.builder

import com.nastynick.billdivider.di.module.BillsFragmentModule
import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(BillsFragmentModule::class))
    abstract fun buildBillsFragment(): BillsFragment

    @ContributesAndroidInjector(modules = arrayOf(FriendsFragmentModule::class))
    abstract fun buildFriendsFragment(): FriendsFragment
}