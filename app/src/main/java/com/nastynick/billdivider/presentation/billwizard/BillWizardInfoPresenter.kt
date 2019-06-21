package com.nastynick.billdivider.presentation.billwizard

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class BillWizardInfoPresenter @Inject constructor() : MvpPresenter<BillWizardInfoView>() {

    fun onStart() {
        viewState.setName("presenter test")
    }
}