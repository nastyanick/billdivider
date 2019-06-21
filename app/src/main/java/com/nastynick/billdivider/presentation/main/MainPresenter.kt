package com.nastynick.billdivider.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.presentation.navigation.BillSummaryScreen
import com.nastynick.billdivider.presentation.navigation.BillsScreen
import com.nastynick.billdivider.presentation.navigation.FriendsScreen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: Router) : MvpPresenter<MainView>() {

    fun onCurrentBillsNavigationButtonClick() {
        router.navigateTo(BillSummaryScreen())
    }

    fun onBillsNavigationButtonClick() {
        router.newRootScreen(BillsScreen())
    }

    fun onFriendsNavigationButtonClick() {
        router.newRootScreen(FriendsScreen())
    }

    fun onAppStarted() {
        router.newRootScreen(BillsScreen())
    }
}