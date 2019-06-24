package com.nastynick.billdivider.presentation.billwizard.details

import android.Manifest
import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.BillDetails
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import com.nastynick.billdivider.presentation.service.LocationService
import com.nastynick.billdivider.presentation.util.DateFormat
import com.tbruyelle.rxpermissions2.RxPermissions
import ru.terrakok.cicerone.Router
import java.util.*
import javax.inject.Inject

@InjectViewState
class BillWizardDetailsPresenter @Inject constructor(
        private val billInteractor: BillInteractor,
        private val router: Router,
        private val rxPermissions: RxPermissions,
        private val locationService: LocationService,
        private val dateFormat: DateFormat
) : BasePresenter<BillWizardDetailsView>() {

    private var bill = BillDetails()

    override fun onFirstViewAttach() {
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { granted -> if (granted) requestAddress() }
                .connect()

        viewState.setDefaultBillName(1)
        setTime()
    }

    private fun setTime() {
        val billDate = Date()
        bill = bill.copy(time = billDate)
        viewState.setTime(dateFormat.formatWithTime(billDate))
    }

    private fun requestAddress() {
        locationService
                .getAddress()
                .subscribe(viewState::setAddress)
                .connect()
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
}