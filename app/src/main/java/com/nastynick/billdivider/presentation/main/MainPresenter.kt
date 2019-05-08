package com.nastynick.billdivider.presentation.main

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val router: MainRouter) : MvpPresenter<MainView>() {

    fun addFriendClick() {
        router.openContactsList()
    }

    fun addBillClick() {
        router.openBillWizard()
    }
}