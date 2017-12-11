package com.nastynick.billdivider.data

import com.google.firebase.database.DataSnapshot
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.util.firebaseSingleEventObservable
import com.nastynick.billdivider.data.util.mapTo
import com.nastynick.billdivider.domain.repository.BillsRepository
import io.reactivex.Observable
import javax.inject.Inject


class BillsRepositoryImpl @Inject constructor(private val databaseHolder: DatabaseHolder) : BillsRepository {

    private val BILLS_DATABASE_REFERENCE = "bills"

    override fun getBills(): Observable<List<Bill>> {
        return firebaseSingleEventObservable(getBillsQuery(), this::mapDataSnapshotToBillsList)
    }

    override fun saveBill(bill: Bill) {
        getBillsQuery().push().setValue(bill)
    }

    private fun mapDataSnapshotToBillsList(dataSnapshot: DataSnapshot): List<Bill> {
        return dataSnapshot.children.map { it.mapTo(Bill::class.java) }
    }

    private fun getBillsQuery() = databaseHolder.reference.child(BILLS_DATABASE_REFERENCE)
}