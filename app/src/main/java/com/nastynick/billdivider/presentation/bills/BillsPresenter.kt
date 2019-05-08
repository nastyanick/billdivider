package com.nastynick.billdivider.presentation.bills

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.domain.usecase.bill.ReadBillsUseCase
import javax.inject.Inject

@InjectViewState
class BillsPresenter @Inject constructor(
        val readBillsUseCase: ReadBillsUseCase
) : MvpPresenter<BillsView>() {

    fun onStart() {
        readBillsUseCase.readBills().subscribe(viewState::showBills)
    }
}