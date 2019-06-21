package com.nastynick.billdivider.presentation.billwizard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.layout_bill_info.*
import java.util.*
import javax.inject.Inject

class BillWizardInfoActivity : BaseActivity(), BillWizardInfoView {
    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, BillWizardInfoActivity::class.java)
        }
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: BillWizardInfoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_wizard_info)

        presenter.onStart()
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun setName(name: String) {
        viewBillInfoTextViewName.setText("Test name")
    }

    override fun setTime(date: Date) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    override fun setAddress(address: String) {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }
}