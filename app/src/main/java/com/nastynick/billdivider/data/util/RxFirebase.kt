package com.nastynick.billdivider.data.util

import com.google.firebase.FirebaseException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import io.reactivex.Single


fun <T> firebaseEventSingle(query: Query?, mapper: (DataSnapshot) -> T): Single<T> {
    return firebaseEventSingle(query).map(mapper)
}

fun firebaseEventSingle(query: Query?): Single<DataSnapshot> {
    return Single.create { subscriber ->
        query?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                subscriber.onSuccess(dataSnapshot)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                subscriber.onError(FirebaseException(databaseError.message))
            }
        })
    }
}