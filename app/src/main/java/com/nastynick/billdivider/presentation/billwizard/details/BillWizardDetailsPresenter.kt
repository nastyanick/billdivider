package com.nastynick.billdivider.presentation.billwizard.details

import android.Manifest
import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.BillWizardPositionScreen
import com.nastynick.billdivider.presentation.service.LocationService
import com.tbruyelle.rxpermissions2.RxPermissions
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class BillWizardDetailsPresenter @Inject constructor(
        private val router: Router,
        private val rxPermissions: RxPermissions,
        private val locationService: LocationService
) : BasePresenter<BillWizardDetailsView>() {

    override fun onFirstViewAttach() {
        rxPermissions
                .request(Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe { granted -> if (granted) requestLocation() }
                .connect()

        viewState.setName("presenter test")
    }

    private fun requestLocation() {
        locationService.getLocation().subscribe { address ->
            viewState.setAddress(address.getAddressLine(0))
        }.connect()
    }

    fun onAddPositionsClick() {
        router.navigateTo(BillWizardPositionScreen())
    }
}