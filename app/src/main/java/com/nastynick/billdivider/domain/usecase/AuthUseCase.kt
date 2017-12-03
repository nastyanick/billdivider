package com.nastynick.billdivider.domain.usecase

import android.content.Intent
import com.firebase.ui.auth.AuthUI
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.nastynick.billdivider.domain.model.AuthData
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class AuthUseCase @Inject constructor() {
    private val REQUEST_CODE_SIGN_IN = 1

    private val authProviders = mutableListOf(
            AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
            AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build(),
            AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()
    )

    fun getAuthDataIfNotAuthorized(): Observable<AuthData> {
        val user = FirebaseAuth.getInstance().currentUser
        return if (user != null) {
            Observable.empty()
        } else {
            getAuthData()
        }
    }

    private fun getAuthData() = Observable.just(AuthData(getAuthIntent(), REQUEST_CODE_SIGN_IN))

    fun checkIsAuthRequest(resultIsSuccess: Boolean, requestCode: Int): Completable {
        return if (resultIsSuccess && requestCode == REQUEST_CODE_SIGN_IN) {
            Completable.complete()
        } else {
            Completable.error(FirebaseException("Firebase Auth Failed"))
        }
    }

    private fun getAuthIntent(): Intent? {
        return AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(authProviders)
                .build()
    }
}