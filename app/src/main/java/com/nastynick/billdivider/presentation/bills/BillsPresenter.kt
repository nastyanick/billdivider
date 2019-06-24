package com.nastynick.billdivider.presentation.bills

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardFlowScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillsPresenter @Inject constructor(
        private val billInteractor: BillInteractor,
        private val router: Router
) : BasePresenter<BillsView>() {

    override fun onFirstViewAttach() {
        billInteractor
                .getBills()
                .subscribe(::setBills)
                .connect()
    }

    private fun setBills(bills: List<Bill>) {
        viewState.showEmptyView(bills.isEmpty())
        viewState.showBills(bills)
    }

    fun onAddBillClick() {
        router.navigateTo(BillWizardFlowScreen())
    }
}