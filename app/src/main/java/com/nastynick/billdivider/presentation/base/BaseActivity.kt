package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatActivity
import com.nastynick.billdivider.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator

open class BaseActivity : MvpAppCompatActivity() {

    protected val navigator = SupportAppNavigator(this, supportFragmentManager, R.id.container)

}