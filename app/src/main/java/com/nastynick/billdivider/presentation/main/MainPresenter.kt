package com.nastynick.billdivider.presentation.main

import javax.inject.Inject

class MainPresenter @Inject constructor(val view: MainContract.View) : MainContract.Presenter {

    override fun addFriendClick() {
        view.openContactsSelection()
    }

    override fun addBillClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}