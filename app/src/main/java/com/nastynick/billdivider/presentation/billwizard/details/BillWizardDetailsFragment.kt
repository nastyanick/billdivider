package com.nastynick.billdivider.presentation.billwizard.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.ComponentsHolder
import com.nastynick.billdivider.presentation.base.BaseFragment
import com.nastynick.billdivider.presentation.util.afterTextChanged
import kotlinx.android.synthetic.main.fragment_bill_wizard_details.*
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
        ComponentsHolder
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
        fragmentBillWizardDetailsTextViewName.afterTextChanged { presenter.onNameTextChanged(it) }
        fragmentBillWizardDetailsTextViewPlace.afterTextChanged { presenter.onAddressTextChanged(it) }
    }

    override fun setDefaultBillName(billNumber: Int) {
        fragmentBillWizardDetailsTextViewName.setText(String.format(getString(R.string.default_bill_name), billNumber))
    }

    override fun setTime(date: String) {
        fragmentBillWizardDetailsTextViewDate.text = date
    }

    override fun setAddress(address: String) {
        fragmentBillWizardDetailsTextViewPlace.setText(address)
    }
}