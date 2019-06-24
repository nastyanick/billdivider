package com.nastynick.billdivider.presentation.billwizard.summary

import com.nastynick.billdivider.domain.usecase.bill.BillInteractor
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardSummaryPresenterTest {

    private val view: BillWizardSummaryView = mock()
    private val router: Router = mock()
    private val interactor: BillInteractor = mock()

    private val presenter = BillWizardSummaryPresenter(interactor, router)

    @Test
    fun `attach view`() {
    }
}