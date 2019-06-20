package com.nastynick.billdivider.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.presentation.navigation.BillSummaryScreen
import com.nastynick.billdivider.presentation.navigation.BillsScreen
import com.nastynick.billdivider.presentation.navigation.FriendsScreen
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: MainRouter) : MvpPresenter<MainView>() {

    fun onCurrentBillsNavigationButtonClick() {
        router.router?.navigateTo(BillSummaryScreen())
    }

    fun onBillsNavigationButtonClick() {
        router.router?.newRootScreen(BillsScreen())
    }

    fun onFriendsNavigationButtonClick() {
        router.router?.newRootScreen(FriendsScreen())
    }

    fun onAppStarted() {
        router.router?.newRootScreen(BillSummaryScreen())
    }
}