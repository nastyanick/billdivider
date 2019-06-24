package com.nastynick.billdivider.presentation.billwizard.position

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
import kotlinx.android.synthetic.main.fragment_bill_wizard_position.*
import javax.inject.Inject

class BillWizardPositionFragment : BaseFragment(), BillWizardPositionView {

    companion object {
        fun getInstance() = BillWizardPositionFragment()
    }

    @InjectPresenter
    @Inject
    lateinit var presenter: BillWizardPositionPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        ComponentsHolder
                .billWizardComponent(requireActivity(), R.id.container)
                .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bill_wizard_position, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        fragmentBillWizardPositionMaterialButtonAddMore.setOnClickListener { presenter.onAddMoreClick() }
        fragmentBillWizardPositionMaterialButtonDone.setOnClickListener { presenter.onDoneClick() }
    }

}