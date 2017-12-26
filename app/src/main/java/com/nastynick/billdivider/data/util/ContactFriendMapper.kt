package com.nastynick.billdivider.data.util

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend

object ContactFriendMapper {

    fun fromContact(contact: Contact): Friend {
        return Friend().apply {
            name = contact.name
            email = contact.email
            phone = contact.phone
        }
    }
}