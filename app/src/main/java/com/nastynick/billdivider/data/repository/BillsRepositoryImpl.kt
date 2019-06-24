package com.nastynick.billdivider.data.repository

import com.nastynick.billdivider.data.database.dao.BillDao
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import com.nastynick.billdivider.domain.repository.BillsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class BillsRepositoryImpl @Inject constructor(
        private val billDao: BillDao,
        private val scheduler: SchedulersProvider
) : BillsRepository {

    override fun getBills(): Single<List<Bill>> {
        return Single.fromCallable {
            billDao.getAll().map { Bill.fromEntity(it) }
        }
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
    }

    override fun saveBill(bill: Bill): Completable = Completable.complete()

    override fun saveBillDetails(billDetails: BillDetails): Completable {
        return Completable.fromAction {
            val bill = Bill.toEntity(Bill(details = billDetails))
            billDao.save(bill)
        }
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
    }

    override fun getCurrentBill(): Single<Bill> {
        return getBills().map { bills -> bills[0] }

    }
}