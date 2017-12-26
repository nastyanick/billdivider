package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.util.firebaseEventSingle
import com.nastynick.billdivider.data.util.mapToList
import com.nastynick.billdivider.domain.repository.BillsRepository
import io.reactivex.Single
import javax.inject.Inject


class BillsRepositoryImpl @Inject constructor(private val databaseHolder: DatabaseHolder) : BillsRepository {

    private val billsDatabaseReference = "bills"

    override fun getBills(): Single<List<Bill>> {
        return firebaseEventSingle(getBillsQuery()) { it.mapToList(Bill::class.java) }
    }

    override fun saveBill(bill: Bill) {
        getBillsQuery().push().setValue(bill)
    }

    private fun getBillsQuery() = databaseHolder.reference.child(billsDatabaseReference)
}