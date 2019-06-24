package com.nastynick.billdivider

import android.app.Application
import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.di.ComponentsHolder

open class BillDividerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDaggerComponent()
        initContactsProvider()
    }

    private fun initDaggerComponent() {
        ComponentsHolder.plusApplicationComponent(this)
    }

    private fun initContactsProvider() {
        Contacts.initialize(this)
    }
}