package com.nastynick.billdivider.domain.usecase.auth

import android.content.Intent
import com.firebase.ui.auth.AuthUI.*
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.nastynick.billdivider.data.objects.AuthData
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class AuthUseCase @Inject constructor() {

    private val REQUEST_CODE_SIGN_IN = 1
    private val FIREBASE_AUTH_PROVIDERS = listOf(
            IdpConfig.Builder(EMAIL_PROVIDER).build(),
            IdpConfig.Builder(PHONE_VERIFICATION_PROVIDER).build(),
            IdpConfig.Builder(GOOGLE_PROVIDER).build()
    )

    fun getAuthDataIfNotAuthorized(): Observable<AuthData> {
        return if (isUserNotAuthorized()) {
            getAuthDataSource()
        } else {
            getAuthAlreadyCompleteSource()
        }
    }

    fun checkIsAuthSuccessful(resultIsSuccess: Boolean, requestCode: Int): Completable {
        return if (isAuthSuccessful(resultIsSuccess, requestCode)) {
            getAuthCompleteSource()
        } else {
            getAuthErrorSource()
        }
    }

    private fun isUserNotAuthorized(): Boolean {
        val user = FirebaseAuth.getInstance().currentUser
        return user == null
    }

    private fun getAuthAlreadyCompleteSource(): Observable<AuthData> = Observable.empty()
    private fun getAuthDataSource() = Observable.just(AuthData(getAuthIntent(), REQUEST_CODE_SIGN_IN))


    private fun isAuthSuccessful(resultIsSuccess: Boolean, requestCode: Int): Boolean {
        return resultIsSuccess && requestCode == REQUEST_CODE_SIGN_IN
    }

    private fun getAuthCompleteSource() = Completable.complete()
    private fun getAuthErrorSource() = Completable.error(FirebaseException("Firebase Auth Failed"))


    private fun getAuthIntent(): Intent? {
        return getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(FIREBASE_AUTH_PROVIDERS)
                .build()
    }
}