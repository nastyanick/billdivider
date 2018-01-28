package com.nastynick.billdivider.presentation.authorization

import com.nastynick.billdivider.data.objects.AuthData

interface AuthorizationContract {

    interface View {
        fun runAuth(authData: AuthData)
        fun showAuthFailedMessage()
    }


    interface Presenter {
        fun onStart()
        fun onAuthResultReceived(isResultSuccess: Boolean, requestCode: Int)
    }
}