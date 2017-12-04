package com.nastynick.billdivider.presentation.bills

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import kotlinx.android.synthetic.main.bills_fragment.*

class BillsFragment : Fragment() {

    companion object {
        fun getInstance(): BillsFragment {
            return BillsFragment()
        }
    }

    private val adapter = BillsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.bills_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBillsList()
    }

    private fun initBillsList() {
        bills_list.layoutManager = LinearLayoutManager(activity)
        bills_list.adapter = adapter
    }
}