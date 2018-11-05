package com.nastynick.billdivider.data.database.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class FriendEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null

    var name: String? = null
    var email: String? = null
    var phone: String? = null
}