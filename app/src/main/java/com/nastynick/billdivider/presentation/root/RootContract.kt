package com.nastynick.billdivider.presentation.root

interface RootContract {

    interface Presenter {
        fun addFriendClick()
        fun addBillClick()
    }

    interface View {
        fun openContactsSelection()
    }
}

