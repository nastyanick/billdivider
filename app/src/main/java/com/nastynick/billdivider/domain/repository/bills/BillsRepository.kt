package com.nastynick.billdivider.domain.repository.bills

import com.nastynick.billdivider.domain.model.bills.Bill
import io.reactivex.Observable

interface BillsRepository {
    fun getBills(): Observable<List<Bill>>
    fun saveBill(bill: Bill)
}