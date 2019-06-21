package com.nastynick.billdivider.presentation.billwizard.details

import com.arellomobile.mvp.MvpView
import java.util.*

interface BillWizardDetailsView : MvpView {
    fun setName(name: String)
    fun setTime(date: Date)
    fun setAddress(address: String)
}