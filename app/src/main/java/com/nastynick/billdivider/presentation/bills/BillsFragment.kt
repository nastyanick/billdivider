package com.nastynick.billdivider.presentation.bills

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Bill
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_bills.*
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
        return inflater.inflate(R.layout.fragment_bills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBillsList()
        presenter.onStart()
    }

    override fun showBills(bills: List<Bill>) {
        adapter.setData(bills)
        adapter.notifyDataSetChanged()
    }

    private fun initBillsList() {
        fragmentBillsRecyclerView.layoutManager = LinearLayoutManager(activity)
        fragmentBillsRecyclerView.adapter = adapter
    }
}