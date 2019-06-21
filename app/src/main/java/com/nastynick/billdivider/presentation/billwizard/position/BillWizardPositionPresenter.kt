package com.nastynick.billdivider.presentation.billwizard.position

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionsScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardPositionPresenter @Inject constructor(
        private val router: Router
) : BasePresenter<BillWizardPositionView>() {

    fun onAddMoreClick() {
        router.exit()
        router.navigateTo(BillWizardPositionScreen())
    }

    fun onDoneClick() {
        router.navigateTo(BillWizardPositionsScreen())
    }

}