package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.authorization.SplashActivity
import com.nastynick.billdivider.di.module.AuthorizationActivityModule
import com.nastynick.billdivider.di.module.RootActivityModule
import com.nastynick.billdivider.di.scope.ActivityScope
import com.nastynick.billdivider.root.view.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@ActivityScope
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(RootActivityModule::class))
    @ActivityScope
    abstract fun bindRootActivity(): RootActivity

    @ContributesAndroidInjector(modules = arrayOf(AuthorizationActivityModule::class))
    @ActivityScope
    abstract fun bindAuthorizationActivity(): SplashActivity
}