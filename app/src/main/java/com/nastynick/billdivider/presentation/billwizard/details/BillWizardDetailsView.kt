package com.nastynick.billdivider.presentation.billwizard.details

import com.arellomobile.mvp.MvpView

interface BillWizardDetailsView : MvpView {
    fun setDefaultBillName(billNumber: Int)
    fun setTime(date: String)
    fun setAddress(address: String)
}