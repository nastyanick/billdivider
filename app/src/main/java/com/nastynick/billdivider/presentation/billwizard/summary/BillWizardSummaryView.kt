package com.nastynick.billdivider.presentation.billwizard.summary

import com.arellomobile.mvp.MvpView

interface BillWizardSummaryView: MvpView {
    fun showAddress(address: String)
}