package com.nastynick.billdivider.presentation.billwizard.details

import android.Manifest
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.service.LocationService
import com.nastynick.billdivider.presentation.util.DateFormat
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

    private lateinit var rxPermissions: RxPermissions
    private lateinit var locationService: LocationService
    private lateinit var dateFormat: DateFormat

    private lateinit var presenter: BillWizardDetailsPresenter

    private val address = "Samara, ul. Lesnaya, 100"

    @Before
    fun setUp() {
        val billInteractor: BillInteractor = mock()
        val router: Router = mock()

        rxPermissions = mock()
        locationService = mock()
        dateFormat = mock()

        whenever(locationService.getAddress()).thenReturn(Single.just(address))

        whenever(rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION))
                .thenReturn(Observable.just(true))

        presenter = BillWizardDetailsPresenter(
                billInteractor,
                router,
                rxPermissions,
                locationService,
                dateFormat
        )
    }

    @Test
    fun `attach view show address`() {
        presenter.attachView(view)
        verify(view).setAddress(address)
    }

    @Test
    fun `attach view show default bill name`() {
        presenter.attachView(view)
        verify(view).setDefaultBillName(1)
    }

    @Test
    fun `attach view show time`() {
        val formattedDate = "16:29 29.03.2019"
        whenever(dateFormat.formatWithTime(any())).thenReturn(formattedDate)

        presenter.attachView(view)

        verify(view).setTime(formattedDate)
    }
}