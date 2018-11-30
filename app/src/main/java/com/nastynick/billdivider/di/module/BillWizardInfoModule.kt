package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoContract
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoPresenter
import dagger.Module
import dagger.Provides

@Module
class BillWizardInfoModule(val activity: BillWizardInfoActivity) {

    @Provides
    fun provideBillWizardInfoView(): BillWizardInfoContract.View = activity

    @Provides
    fun provideBillWizardInfoPresenter(presenter: BillWizardInfoPresenter): BillWizardInfoContract.Presenter = presenter
}