package com.nastynick.billdivider.presentation.billwizard.positions

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
import kotlinx.android.synthetic.main.fragment_bill_wizard_positions.*
import javax.inject.Inject

class BillWizardPositionsFragment : BaseFragment(), BillWizardPositionsView {

    companion object {
        fun getInstance() = BillWizardPositionsFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: BillWizardPositionsPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        DependencyResolver
                .billWizardComponent(requireActivity(), R.id.container)
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_wizard_positions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

    }

    private fun initListeners() {
        fragmentBillWizardPositionsMaterialButtonAddPositions.setOnClickListener { presenter.onAddPositionClick() }
        fragmentBillWizardPositionsMaterialButtonCalculate.setOnClickListener { presenter.onCalculateClick() }
    }
}