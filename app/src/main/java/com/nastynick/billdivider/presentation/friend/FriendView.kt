package com.nastynick.billdivider.presentation.friend

import com.arellomobile.mvp.MvpView
import com.nastynick.billdivider.data.objects.Friend

interface FriendView: MvpView {
    fun setFriend(friend: Friend)
}