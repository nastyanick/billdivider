package com.nastynick.billdivider.presentation.billsummary

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bill_summary.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class BillSummaryFragment : BaseFragment(), BillSummaryView {

    companion object {
        fun getInstance() = BillSummaryFragment()
    }

    @Inject
    protected lateinit var navigator: Navigator

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder


    @Inject
    @InjectPresenter
    lateinit var presenter: BillSummaryPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        getComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    private fun initListeners() {
        fragmentBillSummaryMaterialButton.setOnClickListener {
            presenter.onAddBillClick()
        }
    }
}