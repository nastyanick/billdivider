package com.nastynick.billdivider.presentation.authorization

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.nastynick.billdivider.R
import com.nastynick.billdivider.data.objects.AuthData
import com.nastynick.billdivider.presentation.Navigator
import com.nastynick.billdivider.presentation.Screens
import com.nastynick.billdivider.presentation.main.MainActivity
import com.nastynick.billdivider.presentation.navigation.NavigatorsHolder
import dagger.android.AndroidInjection
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), AuthorizationContract.View {

    @Inject
    protected lateinit var presenter: AuthorizationContract.Presenter

    @Inject
    protected lateinit var navigatorsHolder: NavigatorsHolder

    private val navigator = SplashNavigator()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        navigatorsHolder.addNavigator(SplashRouter.NAME, navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorsHolder.removeNavigator(SplashRouter.NAME)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        presenter.onAuthResultReceived(Activity.RESULT_OK == resultCode, requestCode)
    }

    override fun runAuth(authData: AuthData) {
        startActivityForResult(authData.authIntent, authData.authRequestCode)
    }

    override fun showAuthFailedMessage() {
        Toast.makeText(this, R.string.auth_error, Toast.LENGTH_LONG).show()
    }

    private inner class SplashNavigator : Navigator() {
        override fun applyCommand(command: Any) {
            if (command is Forward) {
                when (command.screenKey) {
                    Screens.MAIN_SCREEN.name -> MainActivity.getIntent(this@SplashActivity)
                            .let(this@SplashActivity::startActivity)
                }
            } else if (command is Back) {
                finish()
            }
        }

    }
}