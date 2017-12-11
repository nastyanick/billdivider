package com.nastynick.billdivider.presentation.bills

import com.nastynick.billdivider.domain.usecase.bill.ReadBillsUseCase
import javax.inject.Inject

class BillsPresenter @Inject constructor(
        val view: BillsContract.View,
        val readBillsUseCase: ReadBillsUseCase
) : BillsContract.Presenter {

    override fun onStart() {
        readBillsUseCase.readBills().subscribe(view::showBills)
    }
}