package com.nastynick.billdivider.presentation.authorization

import com.nastynick.billdivider.domain.usecase.auth.AuthUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthorizationPresenter @Inject constructor(
        private val view: AuthorizationContract.View,
        private val authUseCase: AuthUseCase
) : AuthorizationContract.Presenter {

    override fun onStart() {
        authUseCase.getAuthDataIfNotAuthorized()
                .doOnTerminate(view::openMainScreen)
                .subscribe(view::runAuth)
    }

    override fun onAuthResultReceived(isResultSuccess: Boolean, requestCode: Int) {
        authUseCase.checkIsAuthSuccessful(isResultSuccess, requestCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::openMainScreen, { view.showAuthFailedMessage() })
    }
}