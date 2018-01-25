package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.data.objects.Friend

interface FriendsContract {

    interface View {
        fun setFriends(friends: List<Friend>)
    }

    interface Presenter {
        fun onStart()
        fun onFriendClick(friend: Friend)
    }
}