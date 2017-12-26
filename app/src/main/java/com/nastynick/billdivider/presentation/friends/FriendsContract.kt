package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.data.objects.Friend

interface FriendsContract {

    interface View {
        fun setFriends(friends: List<Friend>)
        fun openFriend(friendId: String)
    }

    interface Presenter {
        fun onStart()
        fun onFriendClick(friend: Friend)
    }
}