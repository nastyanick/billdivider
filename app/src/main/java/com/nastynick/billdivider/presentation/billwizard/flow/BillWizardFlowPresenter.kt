package com.nastynick.billdivider.presentation.billwizard.flow

import com.nastynick.billdivider.presentation.navigation.BillWizardDetailsScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class BillWizardFlowPresenter @Inject constructor(
        private val router: Router
) {

    fun onFlowStarted() {
        router.newRootScreen(BillWizardDetailsScreen())
    }
}