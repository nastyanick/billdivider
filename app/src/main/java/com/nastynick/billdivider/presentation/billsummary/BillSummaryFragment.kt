package com.nastynick.billdivider.presentation.billsummary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.base.BaseFragment

class BillSummaryFragment : BaseFragment() {

    companion object {
        fun getInstance() = BillSummaryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_summary, container, false)
    }
}