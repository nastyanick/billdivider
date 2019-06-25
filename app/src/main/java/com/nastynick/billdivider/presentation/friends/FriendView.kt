package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.MvpView
import com.nastynick.billdivider.data.objects.Friend

interface FriendView : MvpView {
    fun showFriends(friends: List<Friend>)
    fun openFriendAddingMenu()
    fun closeFriendAddingMenu()
    fun showEmptyView(show: Boolean)
}