package com.nastynick.billdivider.authorization

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.nastynick.billdivider.R
import com.nastynick.billdivider.domain.model.AuthData
import com.nastynick.billdivider.root.view.RootActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), AuthorizationContract.View {

    @Inject
    protected lateinit var presenter: AuthorizationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.onStart()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onAuthResultReceived(Activity.RESULT_OK == resultCode, requestCode)
    }

    override fun runAuth(authData: AuthData) {
        startActivityForResult(authData.authIntent, authData.authRequestCode)
    }

    override fun showAuthFailedMessage() {
        Toast.makeText(this, R.string.auth_error, Toast.LENGTH_LONG).show()
    }

    override fun openRootScreen() {
        RootActivity.getIntent(this).let(this::startActivity)
    }
}