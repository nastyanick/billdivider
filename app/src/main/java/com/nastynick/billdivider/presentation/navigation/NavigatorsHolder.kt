package com.nastynick.billdivider.presentation.navigation

import com.nastynick.billdivider.di.application.ApplicationScope
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

@ApplicationScope
class NavigatorsHolder @Inject constructor() {

    private val container = mutableMapOf<String, Cicerone<Router>>()

    private fun get(name: String): Cicerone<Router>? {
        if (container.contains(name)) {
            return container[name]
        } else {
            val cicerone = Cicerone.create()
            container.put(name, cicerone)
            return cicerone
        }
    }

    fun getRouter(name: String) = get(name)?.router

    fun addNavigator(name: String, navigator: SupportAppNavigator) {
        get(name)?.run {
            navigatorHolder.setNavigator(navigator)
        }
    }

    fun removeNavigator(name: String) {
        get(name)?.run {
            navigatorHolder.removeNavigator()
        }
    }
}