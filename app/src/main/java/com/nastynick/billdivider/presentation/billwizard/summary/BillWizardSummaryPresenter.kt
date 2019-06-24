package com.nastynick.billdivider.presentation.billwizard.summary

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardSummaryPresenter @Inject constructor(
        private val interactor: BillInteractor,
        private val router: Router
) : BasePresenter<BillWizardSummaryView>() {

    override fun onFirstViewAttach() {
        interactor
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