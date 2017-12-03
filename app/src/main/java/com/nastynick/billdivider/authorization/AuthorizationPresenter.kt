package com.nastynick.billdivider.authorization

import com.nastynick.billdivider.domain.usecase.AuthUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthorizationPresenter @Inject constructor(
        val view: AuthorizationContract.View,
        val authUseCase: AuthUseCase
) : AuthorizationContract.Presenter {

    override fun onStart() {
        authUseCase.getAuthDataIfNotAuthorized()
                .doOnTerminate { view.openRootScreen() }
                .subscribe(view::runAuth)
    }

    override fun onAuthResultReceived(isResultSuccess: Boolean, requestCode: Int) {
        authUseCase.checkIsAuthRequest(isResultSuccess, requestCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ view.openRootScreen() }, { view.showAuthFailedMessage() })
    }
}