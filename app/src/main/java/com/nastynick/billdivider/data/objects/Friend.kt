package com.nastynick.billdivider.data.objects

import com.nastynick.billdivider.data.database.objects.FriendEntity

data class Friend(
        val id: Long? = null,
        val name: String? = null,
        val email: String? = null,
        val phone: String? = null
) {
    companion object {

        fun fromEntity(entity: FriendEntity): Friend {
            return Friend(
                    id = entity.id,
                    name = entity.name,
                    email = entity.email,
                    phone = entity.phone
            )
        }

        fun toEntity(friend: Friend): FriendEntity {
            return FriendEntity().apply {
                name = friend.name
                email = friend.email
                phone = friend.phone
            }
        }

        fun toEntity(contact: Contact): FriendEntity {
            return FriendEntity().apply {
                name = contact.name
                email = contact.email
                phone = contact.phone
            }
        }
    }
}