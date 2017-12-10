package com.nastynick.billdivider.presentation.authorization

import com.nastynick.billdivider.domain.model.auth.AuthData

interface AuthorizationContract {

    interface View {
        fun runAuth(authData: AuthData)
        fun showAuthFailedMessage()
        fun openRootScreen()
    }


    interface Presenter {
        fun onStart()
        fun onAuthResultReceived(isResultSuccess: Boolean, requestCode: Int)
    }
}