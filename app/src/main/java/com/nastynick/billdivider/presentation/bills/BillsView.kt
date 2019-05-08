package com.nastynick.billdivider.presentation.bills

import com.arellomobile.mvp.MvpView
import com.nastynick.billdivider.data.objects.Bill

interface BillsView: MvpView {
    fun showBills(bills: List<Bill>)
}