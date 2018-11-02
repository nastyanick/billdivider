package com.nastynick.billdivider.data.util

import com.nastynick.billdivider.data.database.objects.FriendEntity
import com.nastynick.billdivider.data.objects.Friend

object FriendMapper {
    fun fromData(friend: Friend): FriendEntity {
        return FriendEntity().apply {
            name = friend.name
            email = friend.email
            phone = friend.phone
        }
    }

    fun fromEntity(entity: FriendEntity): Friend {
        return Friend().apply {
            id = entity.id
            name = entity.name
            email = entity.email
            phone = entity.phone
        }
    }
}