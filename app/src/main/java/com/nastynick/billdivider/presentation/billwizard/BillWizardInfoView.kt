package com.nastynick.billdivider.presentation.billwizard

import com.arellomobile.mvp.MvpView
import java.util.*

interface BillWizardInfoView: MvpView {
    fun setName(name: String)
    fun setTime(date: Date)
    fun setAddress(address: String)
}