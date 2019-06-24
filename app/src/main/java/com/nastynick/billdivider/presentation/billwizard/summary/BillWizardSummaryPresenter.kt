package com.nastynick.billdivider.presentation.billwizard.summary

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.domain.usecase.bill.GetBillUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardSummaryPresenter @Inject constructor(
        private val getBillUseCase: GetBillUseCase,
        private val router: Router
) : BasePresenter<BillWizardSummaryView>() {

    override fun onFirstViewAttach() {
        getBillUseCase
                .getBill()
                .subscribe(this::showSummary)
                .connect()
    }

    private fun showSummary(bill: Bill) {
        bill.details.address?.let { viewState.showAddress(it) }
    }

    fun onShareButtonClick() {
        //Not implemented yet
    }

    fun onDoneClick() {
        router.finishChain()
    }
}