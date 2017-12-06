package com.nastynick.billdivider.data.util

import com.google.firebase.FirebaseException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable


fun <T> firebaseSingleEventObservable(query: Query?, mapper: (DataSnapshot) -> T): Observable<T> {
    return firebaseSingleEventObservable(query).map(mapper)
}

fun firebaseSingleEventObservable(query: Query?): Observable<DataSnapshot> {
    return Observable.create { subscriber ->
        query?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                subscriber.onNext(dataSnapshot)
                subscriber.onComplete()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                subscriber.onError(FirebaseException(databaseError.message))
            }
        })
    }
}