package com.nastynick.billdivider.di.component

import android.app.Activity
import com.nastynick.billdivider.RootActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ActivityKey(RootActivity::class)
    abstract fun bindRootActivity(builder: RootActivityComponent.Builder): AndroidInjector.Factory <out Activity>
}