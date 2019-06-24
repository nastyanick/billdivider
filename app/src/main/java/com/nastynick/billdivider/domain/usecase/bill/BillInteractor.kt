package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.domain.repository.BillsRepository
import javax.inject.Inject

class BillInteractor @Inject constructor(
        private val repository: BillsRepository
) {

    fun saveBillDetails(billDetails: BillDetails) = repository.saveBillDetails(billDetails)

    fun getBill() = repository.getCurrentBill()

    fun getBills() = repository.getBills()
}