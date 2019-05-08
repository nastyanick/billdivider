package com.nastynick.billdivider.presentation.bills

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.domain.usecase.bill.ReadBillsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class BillsPresenter @Inject constructor(
        private val readBillsUseCase: ReadBillsUseCase
) : BasePresenter<BillsView>() {

    fun onStart() {
        readBillsUseCase
                .readBills()
                .subscribe(viewState::showBills)
                .connect()
    }
}