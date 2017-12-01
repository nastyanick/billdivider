package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.RootActivity
import com.nastynick.billdivider.di.module.RootActivityModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = arrayOf(RootActivityModule::class))
interface RootActivityComponent : AndroidInjector<RootActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<RootActivity>()
}