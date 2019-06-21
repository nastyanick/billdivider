package com.nastynick.billdivider.presentation.billwizard.positions

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import com.nastynick.billdivider.presentation.navigation.BillWizardSummaryScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardPositionsPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<BillWizardPositionsView>() {

    fun onAddPositionClick() {
        router.navigateTo(BillWizardPositionScreen())
    }

    fun onCalculateClick() {
        router.navigateTo(BillWizardSummaryScreen())
    }
}