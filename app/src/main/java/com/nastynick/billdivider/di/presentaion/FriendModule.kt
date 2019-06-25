package com.nastynick.billdivider.di.presentaion

import com.nastynick.billdivider.presentation.friend.FriendActivity
import dagger.Module
import dagger.Provides

@Module
class FriendModule(
        private val activity: FriendActivity
) {

    @Provides
    fun provideFriendId(): Long = activity.getFriendId()
}