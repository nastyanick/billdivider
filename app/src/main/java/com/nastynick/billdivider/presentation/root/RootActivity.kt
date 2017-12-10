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
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_root.*
import javax.inject.Inject

class RootActivity : AppCompatActivity(), RootContract.View, HasSupportFragmentInjector {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, RootActivity::class.java)
        }
    }

    @Inject
    protected lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    protected lateinit var presenter: RootContract.Presenter

    private enum class Page { BILLS, FRIENDS }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        initToolbar()
        initPager()
        initListeners()
    }

    override fun openContactsSelection() {
        ContactsActivity.getIntent(this).let(this::startActivity)
    }

    override fun supportFragmentInjector() = dispatchingFragmentInjector

    private fun initToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun initPager() {
        activityRootPager.adapter = PagerAdapter(supportFragmentManager)
        activityRootTabLayout.setupWithViewPager(activityRootPager)
    }

    private fun initListeners() {
        activityRootButtonAdd.setOnClickListener {
            when (activityRootPager.currentItem) {
                Page.BILLS.ordinal -> presenter.addBillClick() //TODO add contacts access request
                Page.FRIENDS.ordinal -> presenter.addFriendClick()
            }
        }
    }

    private inner class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val titledFragments: List<Pair<Int, Fragment>> = listOf(
                R.string.tab_bills to BillsFragment.getInstance(),
                R.string.tab_friends to BillsFragment.getInstance()
        )

        override fun getItem(position: Int): Fragment? {
            return titledFragments[position].second
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titledFragments[position].first.let(this@RootActivity::getString)
        }

        override fun getCount() = titledFragments.size
    }
}