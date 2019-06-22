package com.nastynick.billdivider.presentation.billwizard.details

import android.Manifest
import android.location.Address
import com.nastynick.billdivider.presentation.service.LocationService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardDetailsPresenterTest {

    private val view: BillWizardDetailsView = mock()

    private val router: Router = mock()
    private val rxPermissions: RxPermissions = mock()
    private val locationService: LocationService = mock()

    private val presenter = BillWizardDetailsPresenter(router, rxPermissions, locationService)


    @Test
    fun `attach view show details`() {
        val placeName = "presenter test"

        val addressLine = "Samara, ul. Eroshevskogo, 31"
        val address: Address = mock()

        whenever(address.getAddressLine(any())).thenReturn(addressLine)
        whenever(locationService.getLocation()).thenReturn(Single.just(address))

        whenever(rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION))
                .thenReturn(Observable.just(true))

        presenter.attachView(view)

        verify(view).setAddress(addressLine)
        verify(view).setName(placeName)
    }
}