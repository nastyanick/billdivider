package com.nastynick.billdivider.presentation.billwizard.positions

import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardPositionsPresenterTest {

    private val view: BillWizardPositionsView = mock()
    private val router: Router = mock()

    private val presenter = BillWizardPositionsPresenter(router)

    @Test
    fun `attach view`() {

    }
}