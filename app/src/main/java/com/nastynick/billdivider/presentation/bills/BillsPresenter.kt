package com.nastynick.billdivider.presentation.bills

import com.nastynick.billdivider.domain.usecase.bill.ReadBillsUseCase
import javax.inject.Inject

class BillsPresenter @Inject constructor(
        val readBillsUseCase: ReadBillsUseCase
) : BillsContract.Presenter {

    override fun onStart(view: BillsContract.View) {
        readBillsUseCase.readBills().subscribe(view::showBills)
    }
}