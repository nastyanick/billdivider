package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.BillsFragmentModule
import com.nastynick.billdivider.presentation.bills.BillsFragment
import dagger.Subcomponent

@Subcomponent(modules = [BillsFragmentModule::class])
interface BillsComponent {
    fun inject(billsFragment: BillsFragment)
}