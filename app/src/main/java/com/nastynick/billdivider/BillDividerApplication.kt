package com.nastynick.billdivider

import android.app.Activity
import android.app.Application
import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class BillDividerApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        initDaggerComponent()
        initContactsProvider()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    private fun initDaggerComponent() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    private fun initContactsProvider() {
        Contacts.initialize(this);
    }
}