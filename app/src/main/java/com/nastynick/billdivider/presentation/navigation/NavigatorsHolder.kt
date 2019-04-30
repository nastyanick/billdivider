package com.nastynick.billdivider.presentation.navigation

import com.nastynick.billdivider.presentation.Navigator
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import javax.inject.Inject

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

    fun addNavigator(name: String, navigator: Navigator) {
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