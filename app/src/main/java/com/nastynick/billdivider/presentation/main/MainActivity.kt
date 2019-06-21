package com.nastynick.billdivider.presentation.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }


    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder

    @Inject
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        getComponent().inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()

        if (savedInstanceState == null) {
            presenter.onAppStarted()
        }
    }

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
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
}