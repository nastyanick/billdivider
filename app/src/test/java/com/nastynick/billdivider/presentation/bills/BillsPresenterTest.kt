package com.nastynick.billdivider.presentation.bills

import com.nastynick.billdivider.data.objects.Bill
import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillsPresenterTest {

    private val interactor: BillInteractor = mock()
    private val view: BillsView = mock()

    private lateinit var presenter: BillsPresenter

    @Before
    fun setUp() {
        val router: Router = mock()

        presenter = BillsPresenter(interactor, router)
    }

    @Test
    fun `attach view show empty stub`() {
        whenever(interactor.getBills()).thenReturn(Single.just(listOf()))

        presenter.attachView(view)

        verify(view).showEmptyView(true)
        verifyNoMoreInteractions(view)
    }
}