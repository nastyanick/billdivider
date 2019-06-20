package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.presentation.navigation.FriendDetailsScreen
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import javax.inject.Inject

class FriendsRouter @Inject constructor(navigatorsHolder: NavigatorsHolder) {
    companion object {
        const val NAME = "friends_router"
    }

    private val router = navigatorsHolder.getRouter(NAME)

    fun openFriendsDetails(friendId: Long) {
        router?.navigateTo(FriendDetailsScreen(friendId))
    }
}