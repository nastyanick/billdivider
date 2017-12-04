package com.nastynick.billdivider.domain.model.bills

import com.nastynick.billdivider.domain.model.HasId
import java.util.*

class Bill() : HasId {

    override var id: String? = null
    var address: String? = null
    var time: Date? = null
    var total: Double? = null

    override fun toString(): String {
        return "id = $id address = $address time = $time total = $total"
    }
}