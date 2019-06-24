package com.nastynick.billdivider.domain.usecase.bill

import com.nastynick.billdivider.domain.repository.BillsRepository
import javax.inject.Inject

class GetBillUseCase @Inject constructor(private val billsRepository: BillsRepository) {

    fun getBill() = billsRepository.getCurrentBill()
}