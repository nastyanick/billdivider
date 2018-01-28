package com.nastynick.billdivider.presentation.billwizard

import java.util.*

interface BillWizardInfoContract {
    interface Presenter {
        fun onStart()
    }

    interface View {
        fun setName(name: String)
        fun setTime(date: Date)
        fun setAddress(address: String)
    }
}