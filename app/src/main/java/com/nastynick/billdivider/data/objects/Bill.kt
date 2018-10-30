package com.nastynick.billdivider.data.objects

import java.util.*

data class Bill(
    var id: String? = null,
    var address: String? = null,
    var time: Date? = null,
    var total: Double? = null
)