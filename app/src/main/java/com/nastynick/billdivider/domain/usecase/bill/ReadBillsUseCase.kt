package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.domain.repository.BillsRepository
import javax.inject.Inject

class ReadBillsUseCase @Inject constructor() {

    @Inject
    protected lateinit var billsRepository: BillsRepository

    fun readBills() = billsRepository.getBills()
}