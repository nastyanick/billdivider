package com.nastynick.billdivider.presentation.main

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver
import com.nastynick.billdivider.presentation.Navigator
import com.nastynick.billdivider.presentation.base.BaseActivity
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private val REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION = 1

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @Inject
    protected lateinit var navigatorsHolder: NavigatorsHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        DependencyResolver.presentationComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()

        if (savedInstanceState == null) {
            presenter.onAppStarted()
        }
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onResume() {
        super.onResume()
        navigatorsHolder.addNavigator(MainRouter.NAME, navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorsHolder.removeNavigator(MainRouter.NAME)
    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<String>,
            grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION -> {
                if (grantResults.isNotEmpty() && isPermissionGranted(grantResults[0])) {
                    openContacts()
                }
            }
        }
    }

    private fun initViews() {
    }

    private fun initListeners() {
        activityMainBottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_main_bottom_navigation_current_bill -> presenter.onCurrentBillsNavigationButtonClick()
                R.id.menu_main_bottom_navigation_bills -> presenter.onBillsNavigationButtonClick()
                R.id.menu_main_bottom_navigation_friends -> presenter.onFriendsNavigationButtonClick()
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun openContacts() {
        ContactsActivity.getIntent(this).let(this::startActivity)
    }

    private fun requestContactsPermission() {
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CODE_GRANT_READ_CONTACTS_PERMISSION
        )
    }

    private fun isPermissionGranted(permissionCheck: Int) =
            PackageManager.PERMISSION_GRANTED == permissionCheck

    inner class MainNavigator : Navigator() {
        override fun applyCommand(command: Any) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        private fun openContactsSelection() {
            val permissionCheck = ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.READ_CONTACTS
            )
            if (isPermissionGranted(permissionCheck)) {
                openContacts()
            } else {
                requestContactsPermission()
            }
        }
    }
}