package com.nastynick.billdivider.presentation.billwizard.details

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import com.nastynick.billdivider.presentation.util.DateFormat
import io.reactivex.Observable
import io.reactivex.Single
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

@InjectViewState
class BillWizardDetailsPresenter @Inject constructor(
        private val billInteractor: BillInteractor,
        private val router: Router,
        private val dateFormat: DateFormat
) : BasePresenter<BillWizardDetailsView>() {

    private var bill = BillDetails()

    override fun onFirstViewAttach() {

        viewState.setDefaultBillName(1)
        viewState.requestAddressSource()

        setTime()
    }

    private fun setTime() {
        val billDate = Date()
        bill = bill.copy(time = billDate)
        viewState.setTime(dateFormat.formatWithTime(billDate))
    }


    fun onAddPositionsClick() {
        billInteractor
                .saveBillDetails(bill)
                .subscribe { router.navigateTo(BillWizardPositionScreen()) }
                .connect()
    }

    fun onNameTextChanged(name: String) {
        bill = bill.copy(name = name)
    }

    fun onAddressTextChanged(address: String) {
        bill = bill.copy(address = address)
    }

    fun onAddressSource(addressSource: Single<String>, addressAccessSource: Observable<Boolean>) {
        addressAccessSource
                .filter { it }
                .switchMapSingle { addressSource }
                .subscribe(viewState::setAddress)
                .connect()
    }
}