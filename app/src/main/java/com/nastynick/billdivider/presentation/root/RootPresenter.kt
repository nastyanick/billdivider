package com.nastynick.billdivider.presentation.root

import javax.inject.Inject

class RootPresenter @Inject constructor(val view: RootContract.View) : RootContract.Presenter {

    override fun addFriendClick() {
        view.openContactsSelection()
    }

    override fun addBillClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}