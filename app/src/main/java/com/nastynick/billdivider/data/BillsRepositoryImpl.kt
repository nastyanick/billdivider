package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.domain.repository.BillsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

// TODO implement repository
class BillsRepositoryImpl @Inject constructor() : BillsRepository {

    override fun getBills(): Single<List<Bill>> {
        return Single.just(listOf())
    }

    override fun saveBill(bill: Bill) = Completable.complete()
}