package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.friend.FriendContact
import com.nastynick.billdivider.presentation.friend.FriendPresenter
import dagger.Module
import dagger.Provides

@Module
class FriendModule(val activity: FriendActivity) {

    @Provides
    fun provideFriendView(): FriendContact.View = activity

    @Provides
    fun provideFriendPresenter(presenter: FriendPresenter): FriendContact.Presenter = presenter

    @Provides
    fun provideFriendId(): Long {
        return 10
    }
}