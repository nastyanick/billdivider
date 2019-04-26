package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.friends.FriendsContract
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import com.nastynick.billdivider.presentation.friends.FriendsPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class FriendsFragmentModule {

    @Provides
    fun provideFriendsPresenter(presenter: FriendsPresenter): FriendsContract.Presenter = presenter
}