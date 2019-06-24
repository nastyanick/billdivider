package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.domain.repository.BillsRepository
import javax.inject.Inject

class SaveBillUseCase @Inject constructor() {

    @Inject
    protected lateinit var billsRepository: BillsRepository

    fun saveBill(bill: Bill) = billsRepository.saveBill(bill)

    fun saveBillDetails(billDetails: BillDetails) = billsRepository.saveBillDetails(billDetails)
}