package com.nastynick.billdivider.presentation.root

interface RootContract {

    interface Presenter {
        enum class Page { BILLS, FRIENDS }

        fun addFriendClick()
        fun addBillClick()
    }

    interface View {
        fun openContactsSelection()
    }
}

