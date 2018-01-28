package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoContract
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class BillWizardInfoModule {
    @Binds
    abstract fun provideBillWizardInfoPresenter(presenter: BillWizardInfoPresenter): BillWizardInfoContract.Presenter

    @Binds
    abstract fun provideBillWizardInfoView(view: BillWizardInfoActivity): BillWizardInfoContract.View
}