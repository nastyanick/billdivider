package com.nastynick.billdivider.presentation.billwizard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nastynick.billdivider.R
import kotlinx.android.synthetic.main.layout_bill_info.*

class BillWizardInfoActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BillWizardInfoActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_wizard_info)

        setTestData()
    }

    private fun setTestData() {
        viewBillInfoTextViewName.setText("Test name")
        viewBillInfoTextViewTime.setText("12.09.2018 \n 5 pm ")
        viewBillInfoTextViewPlace.setText("Some place")
    }
}