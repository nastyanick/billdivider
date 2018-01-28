package com.nastynick.billdivider.presentation.authorization

import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import javax.inject.Inject

class SplashRouter @Inject constructor(navigatorsHolder: NavigatorsHolder) {

    companion object {
        const val NAME = "splash_router"
    }

    private val router = navigatorsHolder.getRouter(NAME)

    fun openMainScreen() {
        router?.run {
            navigateTo(Screens.MAIN_SCREEN.name)
            exit()
        }
    }
}