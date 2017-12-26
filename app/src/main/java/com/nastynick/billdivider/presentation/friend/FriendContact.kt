package com.nastynick.billdivider.presentation.friend

import com.nastynick.billdivider.data.objects.Friend

interface FriendContact {

    interface View {
        fun setFriend(friend: Friend)
    }

    interface Presenter {
        fun onStart()
    }
}