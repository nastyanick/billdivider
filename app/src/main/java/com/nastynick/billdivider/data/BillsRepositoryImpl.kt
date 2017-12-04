package com.nastynick.billdivider.data

import com.google.firebase.database.DataSnapshot
import com.nastynick.billdivider.domain.model.bills.Bill
import com.nastynick.billdivider.domain.repository.bills.BillsRepository
import io.reactivex.Observable
import javax.inject.Inject


class BillsRepositoryImpl @Inject constructor(val databaseManager: DatabaseManager) : BillsRepository {

    private val BILLS_DATABASE_REFERENCE = "bills"

    override fun getBills(): Observable<List<Bill>> {
        return firebaseSingleEventObservable(getBillsQuery(), this::mapDataToBillsList)
    }

    override fun saveBill(bill: Bill) {
        getBillsQuery().push().setValue(bill)
    }

    private fun mapDataToBillsList(dataSnapshot: DataSnapshot): List<Bill> {
        return dataSnapshot.children.map { it.mapTo(Bill::class.java) }
    }

    private fun getBillsQuery() = databaseManager.reference.child(BILLS_DATABASE_REFERENCE)
}