package com.nastynick.billdivider.presentation.billwizard

import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

class BillWizardInfoPresenter @Inject constructor(
) : MvpPresenter<BillWizardInfoView>() {

    fun onStart() {
        viewState.setName("presenter test")
    }
}