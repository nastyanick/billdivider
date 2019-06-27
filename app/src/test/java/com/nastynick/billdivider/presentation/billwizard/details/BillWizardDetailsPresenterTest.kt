package com.nastynick.billdivider.presentation.billwizard.details

import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nastynick.billdivider.presentation.util.DateFormat
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardDetailsPresenterTest {

    private val view: BillWizardDetailsView = mock()

    private lateinit var dateFormat: DateFormat

    private lateinit var presenter: BillWizardDetailsPresenter

    private val address = "Samara, ul. Lesnaya, 100"

    @Before
    fun setUp() {
        val billInteractor: BillInteractor = mock()
        val router: Router = mock()

        dateFormat = mock()

        presenter = BillWizardDetailsPresenter(
                billInteractor,
                router,
                dateFormat
        )
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

    @Test
    fun `address access granted show address`() {
        val accessSource = Observable.just(true)
        val address = "Samara, ul. Lesnaya, 100"
        val addressSource = Single.just(address)

        presenter.attachView(view)
        presenter.onAddressSource(addressSource, accessSource)

        verify(view).setAddress(address)
    }

    @Test
    fun `address access not granted do not show address`() {
        val accessSource = Observable.just(false)
        val addressSource = Single.just(address)

        presenter.attachView(view)
        presenter.onAddressSource(addressSource, accessSource)

        verify(view, never()).setAddress(any())
    }
}