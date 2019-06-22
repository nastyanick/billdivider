package com.nastynick.billdivider.presentation.billwizard.position

import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import ru.terrakok.cicerone.Router

class BillWizardPositionPresenterTest {

    private val view: BillWizardPositionView = mock()
    private val router: Router = mock()

    private val presenter = BillWizardPositionPresenter(router)

    @Test
    fun `attach view`() {

    }

}