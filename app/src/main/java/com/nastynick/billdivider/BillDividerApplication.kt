package com.nastynick.billdivider

import android.app.Activity
import android.app.Application
import com.google.firebase.database.FirebaseDatabase
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
        initDatabase()
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

    private fun initDatabase() {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

}