package com.nastynick.billdivider.presentation.bills

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bills.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class BillsFragment : BaseFragment(), BillsView {

    companion object {
        fun getInstance(): BillsFragment {
            return BillsFragment()
        }
    }

    @Inject
    protected lateinit var adapter: BillsAdapter

    @Inject
    @InjectPresenter
    lateinit var presenter: BillsPresenter

    @Inject
    protected lateinit var navigator: Navigator

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_bills, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun showBills(bills: List<Bill>) {
        adapter.setData(bills)
        adapter.notifyDataSetChanged()
    }

    private fun initView() {
        fragmentBillsRecyclerView.layoutManager = LinearLayoutManager(activity)
        fragmentBillsRecyclerView.adapter = adapter
    }

    private fun initListeners() {
        fragmentBillsSummaryMaterialButton.setOnClickListener {
            presenter.onAddBillClick()
        }
    }
}