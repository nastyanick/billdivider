package com.nastynick.billdivider.presentation.main

import javax.inject.Inject

class MainPresenter @Inject constructor(val view: MainContract.View) : MainContract.Presenter {

    override fun addFriendClick() {
        //TODO refactor with Cicerone
        view.openContactsSelection()
    }

    override fun addBillClick() {
        //TODO refactor with Cicerone
        view.openBillWizard()
    }
}