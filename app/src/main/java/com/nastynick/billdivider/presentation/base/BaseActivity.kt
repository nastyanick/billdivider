package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.ComponentsHolder

open class BaseActivity : MvpAppCompatActivity() {

    fun getComponent() =  ComponentsHolder.presentationComponent(this, R.id.container)
}