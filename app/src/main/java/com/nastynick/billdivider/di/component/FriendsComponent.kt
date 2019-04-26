package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.FriendsFragmentModule
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import dagger.Subcomponent

@Subcomponent(modules = [FriendsFragmentModule::class])
interface FriendsComponent {
    fun inject(fragment: FriendsFragment)
}