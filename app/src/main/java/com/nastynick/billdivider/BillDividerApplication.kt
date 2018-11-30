package com.nastynick.billdivider

import android.app.Application
import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.di.component.DaggerApplicationComponent

class BillDividerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initDaggerComponent()
        initContactsProvider()
    }

    private fun initDaggerComponent() {
    }

    private fun initContactsProvider() {
        Contacts.initialize(this);
    }
}