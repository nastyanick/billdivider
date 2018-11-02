package com.nastynick.billdivider.data.database.objects

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity
class Bill {

    @PrimaryKey
    var id: String? = null

    var address: String? = null
    var time: Date? = null
    var total: Double? = null
}