package com.nastynick.billdivider.presentation.billsummary

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillSummaryPresenter @Inject constructor(
       private val router: Router
) : BasePresenter<BillSummaryView>() {

    fun onAddBillClick() {
        router.navigateTo(BillWizardScreen())
    }
}