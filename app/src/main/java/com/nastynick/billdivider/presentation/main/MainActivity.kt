package com.nastynick.billdivider.presentation.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.Navigator
import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import com.nastynick.billdivider.presentation.main.MainContract.Presenter.Page.BILLS
import com.nastynick.billdivider.presentation.main.MainContract.Presenter.Page.FRIENDS
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainContract.View, HasSupportFragmentInjector {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private val REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION = 1;

    @Inject
    protected lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    protected lateinit var presenter: MainContract.Presenter

    @Inject
    protected lateinit var navigatorsHolder: NavigatorsHolder

    private val navigator = MainNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initPager()
        initListeners()
    }

    override fun onResume() {
        super.onResume()
        navigatorsHolder.addNavigator(MainRouter.NAME, navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorsHolder.removeNavigator(MainRouter.NAME)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION -> {
                if (grantResults.isNotEmpty() && isPermissionGranted(grantResults[0])) {
                    openContacts()
                }
            }
        }
    }

    override fun supportFragmentInjector() = dispatchingFragmentInjector

    private fun initToolbar() {
        setSupportActionBar(activityMainToolbar)
    }

    private fun initPager() {
        activityMainPager.adapter = PagerAdapter(supportFragmentManager)
        activityMainTabLayout.setupWithViewPager(activityMainPager)
    }

    private fun initListeners() {
        activityMainButtonAdd.setOnClickListener {
            when (activityMainPager.currentItem) {
                BILLS.ordinal -> presenter.addBillClick()
                FRIENDS.ordinal -> presenter.addFriendClick()
            }
        }
    }

    private fun openContacts() {
        ContactsActivity.getIntent(this).let(this::startActivity)
    }

    private fun requestContactsPermission() {
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION)
    }

    private fun isPermissionGranted(permissionCheck: Int) = PackageManager.PERMISSION_GRANTED == permissionCheck

    private inner class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

        private val titledFragments: List<Pair<Int, Fragment>> = listOf(
                R.string.tab_bills to BillsFragment.getInstance(),
                R.string.tab_friends to FriendsFragment.getInstance()
        )

        override fun getItem(position: Int): Fragment? {
            return titledFragments[position].second
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titledFragments[position].first.let(this@MainActivity::getString)
        }

        override fun getCount() = titledFragments.size
    }

    inner class MainNavigator : Navigator() {
        override fun applyCommand(command: Any) {
            if (command is Forward) {
                when (command.screenKey) {
                    Screens.CONTACTS_LIST.name -> openContactsSelection()
                    Screens.BILL_WIZARD.name -> openBillWizard()
                }
            }
        }

        private fun openContactsSelection() {
            val permissionCheck = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_CONTACTS)
            if (isPermissionGranted(permissionCheck)) {
                openContacts()
            } else {
                requestContactsPermission()
            }
        }

        private fun openBillWizard() {
            BillWizardInfoActivity.getIntent(this@MainActivity)
                    .let(this@MainActivity::startActivity)
        }

    }
}