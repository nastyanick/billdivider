package com.nastynick.billdivider.presentation.main

interface MainContract {

    interface Presenter {
        enum class Page { BILLS, FRIENDS }

        fun addFriendClick()
        fun addBillClick()
    }

    interface View {
        fun openContactsSelection()
    }
}

