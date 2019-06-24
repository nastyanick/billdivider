package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.database.dao.BillDao
import com.nastynick.billdivider.data.database.objects.BillEntity
import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import com.nastynick.billdivider.domain.repository.BillsRepository
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import javax.inject.Inject

class BillsRepositoryImpl @Inject constructor(
        private val billDao: BillDao,
        private val scheduler: SchedulersProvider
) : BillsRepository {

    override fun getBills(): Single<List<Bill>> {
        return Single.just(listOf())
    }

    override fun saveBill(bill: Bill): Completable = Completable.complete()

    override fun saveBillDetails(billDetails: BillDetails): Completable {
        return Completable.fromAction {
            val entity = BillEntity()
            entity.address = billDetails.address
            entity.time = billDetails.time
            entity.name = billDetails.name
            billDao.save(entity)
        }
                .subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
    }
}