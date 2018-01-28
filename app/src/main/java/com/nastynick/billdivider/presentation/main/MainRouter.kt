package com.nastynick.billdivider.presentation.main

import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import javax.inject.Inject

class MainRouter @Inject constructor(private val navigatorsHolder: NavigatorsHolder) {

    companion object {
        const val NAME = "main_router"
    }

    val router = navigatorsHolder.getRouter(NAME)

    fun openContactsList() {
        router?.navigateTo(Screens.CONTACTS_LIST.name)
    }

    fun openBillWizard() {
        router?.navigateTo(Screens.BILL_WIZARD.name)
    }
}