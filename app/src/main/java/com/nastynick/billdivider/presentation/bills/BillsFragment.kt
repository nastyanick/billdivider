package com.nastynick.billdivider.presentation.bills

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.domain.model.bills.Bill
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.bills_fragment.*
import javax.inject.Inject

class BillsFragment: Fragment(), BillsContract.View {

    companion object {
        fun getInstance(): BillsFragment {
            return BillsFragment()
        }
    }


    @Inject
    protected lateinit var presenter: BillsContract.Presenter

    @Inject
    protected lateinit var adapter: BillsAdapter


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.bills_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBillsList()
        presenter.onStart()
    }

    override fun showBills(bills: List<Bill>) {
        adapter.setData(bills)
        adapter.notifyDataSetChanged()
    }

    private fun initBillsList() {
        bills_list.layoutManager = LinearLayoutManager(activity)
        bills_list.adapter = adapter
    }
}