package com.nastynick.billdivider.presentation.billwizard.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_bill_wizard_details.*
import kotlinx.android.synthetic.main.layout_bill_info.*
import java.util.*
import javax.inject.Inject

class BillWizardDetailsFragment : BaseFragment(), BillWizardDetailsView {

    companion object {
        fun getInstance(): BillWizardDetailsFragment = BillWizardDetailsFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: BillWizardDetailsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        DependencyResolver
                .billWizardComponent(requireActivity(), R.id.container)
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_wizard_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        fragmentBillWizardDetailsMaterialButtonAddPositions.setOnClickListener { presenter.onAddPositionsClick() }
    }

    override fun setName(name: String) {
        viewBillInfoTextViewName.setText(name)
    }

    override fun setTime(date: Date) {
    }

    override fun setAddress(address: String) {
        viewBillInfoTextViewPlace.setText(address)
    }
}