package com.nastynick.billdivider.presentation.base

import com.arellomobile.mvp.MvpAppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.di.DependencyResolver

open class BaseActivity : MvpAppCompatActivity() {

    fun getComponent() =  DependencyResolver.presentationComponent(this, R.id.container)
}