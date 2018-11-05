package com.nastynick.billdivider.presentation.authorization

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nastynick.billdivider.R
import com.nastynick.billdivider.presentation.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        MainActivity.getIntent(this).let(this::startActivity)
    }
}