package com.nastynick.billdivider.presentation.bills

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.domain.usecase.bill.ReadBillsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardFlowScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillsPresenter @Inject constructor(
    private val readBillsUseCase: ReadBillsUseCase,
    private val router: Router
) : BasePresenter<BillsView>() {

    fun onStart() {
        readBillsUseCase
                .readBills()
                .subscribe(viewState::showBills)
                .connect()
    }

    fun onAddBillClick() {
        router.navigateTo(BillWizardFlowScreen())
    }
}