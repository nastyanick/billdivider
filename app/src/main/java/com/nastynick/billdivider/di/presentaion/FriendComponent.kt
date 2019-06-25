package com.nastynick.billdivider.di.presentaion

import com.nastynick.billdivider.presentation.friend.FriendActivity
import dagger.Subcomponent

@Subcomponent(modules = [FriendModule::class])
interface FriendComponent {

    fun inject(friendActivity: FriendActivity)

}