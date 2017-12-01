package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.RootActivity
import com.nastynick.billdivider.di.module.RootActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(RootActivityModule::class))
    abstract fun bindRootActivity(): RootActivity
}