package com.nastynick.billdivider.presentation.billwizard.summary

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardSummaryPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<BillWizardSummaryView>() {

    fun onShareButtonClick() {

    }

    fun onDoneClick() {
        router.finishChain()
    }
}