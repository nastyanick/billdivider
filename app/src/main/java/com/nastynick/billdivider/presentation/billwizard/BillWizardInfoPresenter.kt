package com.nastynick.billdivider.presentation.billwizard

import javax.inject.Inject

class BillWizardInfoPresenter @Inject constructor(val view: BillWizardInfoContract.View
) : BillWizardInfoContract.Presenter {

    override fun onStart() {
        view.setName("presenter test")
    }
}