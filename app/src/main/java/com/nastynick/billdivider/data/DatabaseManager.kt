package com.nastynick.billdivider.data

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseManager @Inject constructor() {
    val reference: DatabaseReference by lazy { FirebaseDatabase.getInstance().reference }
}