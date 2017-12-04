package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.domain.model.bills.Bill
import com.nastynick.billdivider.domain.repository.bills.BillsRepository
import javax.inject.Inject

class BillSaveUseCase @Inject constructor() {

    @Inject
    protected lateinit var billsRepository: BillsRepository

    fun saveBill(bill: Bill) = billsRepository.saveBill(bill)
}