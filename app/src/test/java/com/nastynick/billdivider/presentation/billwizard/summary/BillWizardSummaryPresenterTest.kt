package com.nastynick.billdivider.presentation.billwizard.summary

import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardSummaryPresenterTest {

    private val view: BillWizardSummaryView = mock()
    private val router: Router = mock()

    private val presenter = BillWizardSummaryPresenter(router)

    @Test
    fun `attach view`() {
    }
}