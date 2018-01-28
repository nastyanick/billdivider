package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import javax.inject.Inject

class ContactsRouter @Inject constructor(private val navigatorsHolder: NavigatorsHolder) {
    companion object {
        const val NAME = "contacts_router"
    }

    private val router = navigatorsHolder.getRouter(NAME)

    fun close() {
        router?.exit()
    }
}