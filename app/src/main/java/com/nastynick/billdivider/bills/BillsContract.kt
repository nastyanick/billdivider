package com.nastynick.billdivider.bills

import com.nastynick.billdivider.domain.model.bills.Bill

interface BillsContract {

    interface View {
        fun showBills(bills: List<Bill>)
    }

    interface Presenter {
        fun onStart()
    }
}