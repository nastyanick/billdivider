package com.nastynick.billdivider

import com.google.firebase.database.*


object DatabaseManager {
    private val database: DatabaseReference by lazy { FirebaseDatabase.getInstance().reference }
}