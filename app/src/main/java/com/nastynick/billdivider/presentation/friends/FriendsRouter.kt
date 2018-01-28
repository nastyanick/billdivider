package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import javax.inject.Inject

class FriendsRouter @Inject constructor(navigatorsHolder: NavigatorsHolder) {
    companion object {
        const val NAME = "friends_router"
    }

    private val router = navigatorsHolder.getRouter(NAME)

    fun openFriendsDetails(friendId: String?) {
        router?.navigateTo(Screens.FRIEND_DETAILS.name, friendId)
    }
}