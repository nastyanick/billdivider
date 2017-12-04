package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.domain.repository.bills.BillsRepository
import javax.inject.Inject

class BillsReadUseCase @Inject constructor() {

    @Inject
    protected lateinit var billsRepository: BillsRepository

    fun readBills() = billsRepository.getBills()
}