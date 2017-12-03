package com.nastynick.billdivider.domain.model.auth

import android.content.Intent

data class AuthData(val authIntent: Intent?, val authRequestCode: Int)