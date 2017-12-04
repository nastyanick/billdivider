package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.di.scope.ActivityScope
import com.nastynick.billdivider.presentation.authorization.SplashActivity
import com.nastynick.billdivider.presentation.root.RootActivity
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