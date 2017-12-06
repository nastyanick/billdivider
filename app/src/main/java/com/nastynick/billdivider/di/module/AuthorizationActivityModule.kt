package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.di.annotation.scope.ActivityScope
import com.nastynick.billdivider.presentation.authorization.AuthorizationContract
import com.nastynick.billdivider.presentation.authorization.AuthorizationPresenter
import com.nastynick.billdivider.presentation.authorization.SplashActivity
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