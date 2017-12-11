package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Bill
import io.reactivex.Observable

interface BillsRepository {
    fun getBills(): Observable<List<Bill>>
    fun saveBill(bill: Bill)
}