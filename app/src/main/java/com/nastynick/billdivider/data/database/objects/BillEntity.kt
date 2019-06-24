package com.nastynick.billdivider.data.database.objects

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
class BillEntity {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var name: String? = null
    var address: String? = null
    var time: Date? = null
    var total: Double? = null
}