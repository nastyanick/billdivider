package com.nastynick.billdivider.presentation.main

import javax.inject.Inject

class MainPresenter @Inject constructor(private val router: MainRouter) : MainContract.Presenter {

    override fun addFriendClick() {
        router.openContactsList()
    }

    override fun addBillClick() {
        router.openBillWizard()
    }
}