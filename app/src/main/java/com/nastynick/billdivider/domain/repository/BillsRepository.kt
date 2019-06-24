package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.objects.BillDetails
import io.reactivex.Completable
import io.reactivex.Single

interface BillsRepository {

    fun getBills(): Single<List<Bill>>

    fun saveBill(bill: Bill): Completable
    fun saveBillDetails(billDetails: BillDetails): Completable
}