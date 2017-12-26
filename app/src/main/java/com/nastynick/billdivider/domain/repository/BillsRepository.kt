package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Bill
import io.reactivex.Single

interface BillsRepository {
    fun getBills(): Single<List<Bill>>
    fun saveBill(bill: Bill)
}