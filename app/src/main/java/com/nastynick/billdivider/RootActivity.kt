package com.nastynick.billdivider

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.nastynick.billdivider.bills.RootView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_root.*
import javax.inject.Inject

class RootActivity : AppCompatActivity(), RootView {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        initToolbar()
        initPager()
    }

    private fun initPager() {

    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        toolbar.title = getString(R.string.app_name)
    }

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RootActivity::class.java)
        }
    }
}