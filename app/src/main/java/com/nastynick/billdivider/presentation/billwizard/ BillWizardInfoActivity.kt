package com.nastynick.billdivider.presentation.billwizard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nastynick.billdivider.R
import kotlinx.android.synthetic.main.layout_bill_info.*
import java.util.*
import javax.inject.Inject

class BillWizardInfoActivity : AppCompatActivity(), BillWizardInfoContract.View {
    companion object {

        fun getIntent(context: Context): Intent {
            return Intent(context, BillWizardInfoActivity::class.java)
        }
    }

    @Inject
    protected lateinit var presenter: BillWizardInfoContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_wizard_info)

        presenter.onStart()
    }

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