package com.nastynick.billdivider.di.module.builder

import com.nastynick.billdivider.di.annotation.scope.ActivityScope
import com.nastynick.billdivider.di.module.AuthorizationActivityModule
import com.nastynick.billdivider.di.module.RootActivityModule
import com.nastynick.billdivider.presentation.authorization.SplashActivity
import com.nastynick.billdivider.presentation.root.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@ActivityScope
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(RootActivityModule::class))
    @ActivityScope
    abstract fun buildRootActivity(): RootActivity

    @ContributesAndroidInjector(modules = arrayOf(AuthorizationActivityModule::class))
    @ActivityScope
    abstract fun buildAuthorizationActivity(): SplashActivity
}