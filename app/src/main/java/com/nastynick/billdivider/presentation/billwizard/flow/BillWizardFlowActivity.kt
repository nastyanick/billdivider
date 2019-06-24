package com.nastynick.billdivider.presentation.billwizard.flow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.ComponentsHolder
import com.nastynick.billdivider.presentation.base.BaseActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class BillWizardFlowActivity : BaseActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, BillWizardFlowActivity::class.java)
        }
    }

    @Inject
    protected lateinit var presenter: BillWizardFlowPresenter

    @Inject
    protected lateinit var navigator: Navigator

    @Inject
    protected lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        ComponentsHolder
                .billWizardComponent(this, R.id.container)
                .inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_wizard)

        presenter.onFlowStarted()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        ComponentsHolder.destroyBillWizardComponent()
        super.onDestroy()
    }
}