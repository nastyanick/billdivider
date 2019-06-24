package com.nastynick.billdivider.data.objects

import com.nastynick.billdivider.data.database.objects.BillEntity

data class Bill(
        val id: Int? = null,
        val details: BillDetails
) {
    companion object {

        fun fromEntity(entity: BillEntity): Bill {
            return with(entity) {
                Bill(id, BillDetails(address, time, name))
            }
        }

        fun toEntity(bill: Bill): BillEntity {
            val entity = BillEntity()
            with(bill.details) {
                entity.address = address
                entity.time = time
                entity.name = name
            }
            return entity
        }
    }
}

