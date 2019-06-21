package com.nastynick.billdivider.presentation.billwizard.details

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardDetailsPresenter @Inject constructor(
        private val router: Router
) : MvpPresenter<BillWizardDetailsView>() {

    fun onStart() {
        viewState.setName("presenter test")
    }

    fun onAddPositionsClick() {
        router.navigateTo(BillWizardPositionScreen())
    }
}