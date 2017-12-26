package com.nastynick.billdivider.di.module.builder

import com.nastynick.billdivider.presentation.friends.FriendsContract
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import com.nastynick.billdivider.presentation.friends.FriendsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class FriendsFragmentModule {

    @Binds
    abstract fun provideFriendsView(view: FriendsFragment): FriendsContract.View

    @Binds
    abstract fun provideFriendsPresenter(presenter: FriendsPresenter): FriendsContract.Presenter
}