package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.authorization.AuthorizationContract
import com.nastynick.billdivider.authorization.AuthorizationPresenter
import com.nastynick.billdivider.authorization.SplashActivity
import com.nastynick.billdivider.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@ActivityScope
@Module
abstract class AuthorizationActivityModule {

    @ActivityScope
    @Binds
    abstract fun providesView(activity: SplashActivity): AuthorizationContract.View

    @ActivityScope
    @Binds
    abstract fun providesPresenter(presenter: AuthorizationPresenter): AuthorizationContract.Presenter
}