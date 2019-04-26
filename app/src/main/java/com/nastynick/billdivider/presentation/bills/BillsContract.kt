package com.nastynick.billdivider.presentation.bills

import com.nastynick.billdivider.data.objects.Bill

interface BillsContract {

    interface View {
        fun showBills(bills: List<Bill>)
    }

    interface Presenter {
        fun onStart(view: View)
    }
}