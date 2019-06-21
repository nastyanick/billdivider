package com.nastynick.billdivider.presentation.bills

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bills.*
import javax.inject.Inject

class BillsFragment : BaseFragment(), BillsView {

    companion object {
        fun getInstance(): BillsFragment {
            return BillsFragment()
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: BillsPresenter

    @Inject
    protected lateinit var adapter: BillsAdapter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBillsList()
        presenter.onStart()
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showBills(bills: List<Bill>) {
        adapter.setData(bills)
        adapter.notifyDataSetChanged()
    }

    private fun initBillsList() {
        fragmentBillsRecyclerView.layoutManager = LinearLayoutManager(activity)
        fragmentBillsRecyclerView.adapter = adapter
    }
}