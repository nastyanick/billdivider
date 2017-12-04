package com.nastynick.billdivider.bills.presenter

import com.nastynick.billdivider.bills.BillsContract
import com.nastynick.billdivider.domain.usecase.bill.BillsReadUseCase
import javax.inject.Inject

class BillsPresenter @Inject constructor(
        val view: BillsContract.View,
        val billsReadUseCase: BillsReadUseCase
) : BillsContract.Presenter {

    override fun onStart() {
        billsReadUseCase.readBills().subscribe(view::showBills)
    }
}