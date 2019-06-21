package com.nastynick.billdivider.presentation.billsummary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bill_summary.*
import javax.inject.Inject

class BillSummaryFragment : BaseFragment(), BillSummaryView {

    companion object {
        fun getInstance() = BillSummaryFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: BillSummaryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DependencyResolver.presentationComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    private fun initListeners() {
        fragmentBillSummaryMaterialButton.setOnClickListener {
            presenter.onAddBillClick()
        }
    }
}