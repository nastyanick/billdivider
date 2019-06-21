package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.MvpView
import com.nastynick.billdivider.data.objects.Friend

interface FriendView : MvpView {
    fun setFriends(friends: List<Friend>)
    fun openFriendAddingMenu()
}