package com.nastynick.billdivider.presentation.util

import android.app.Application
import android.widget.Toast
import javax.inject.Inject

class StubUtil @Inject constructor(
        private val application: Application
) {

    fun showUnderDevelopmentMessage() {
        Toast.makeText(application, "В разработке", Toast.LENGTH_SHORT).show()
    }
}