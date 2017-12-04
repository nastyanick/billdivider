package com.nastynick.billdivider.presentation.root

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.bills.BillsFragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_root.*
import javax.inject.Inject

class RootActivity : AppCompatActivity(), RootView, HasSupportFragmentInjector {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RootActivity::class.java)
        }
    }

    @Inject
    protected lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        initToolbar()
        initPager()
    }

    override fun supportFragmentInjector() = dispatchingFragmentInjector

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }


    private fun initPager() {
        rootPager.adapter = PagerAdapter(supportFragmentManager)
    }

    internal class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        private val PAGER_ITEMS_COUNT = 2
        private val fragments: List<Fragment> = arrayListOf(BillsFragment.getInstance(), BillsFragment.getInstance())

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount() = PAGER_ITEMS_COUNT
    }
}