package com.nastynick.billdivider.domain.usecase.auth

import io.reactivex.Completable
import javax.inject.Inject


class AuthUseCase @Inject constructor() {

    fun checkIsAuthSuccessful(resultIsSuccess: Boolean, requestCode: Int): Completable {
        return Completable.complete()
    }

    fun authorizeAnonymously(): Completable {
        return Completable.create { subscriber ->
            if (isUserAuthorized()) {
                subscriber.onComplete()
                return@create
            }
            subscriber.onComplete()
        }
    }


    private fun isUserAuthorized(): Boolean {
        return true
    }
}