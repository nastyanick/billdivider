package com.nastynick.billdivider.data

import com.google.firebase.database.DataSnapshot
import com.nastynick.billdivider.domain.model.HasId

fun <T> DataSnapshot.mapTo(javaClass: Class<T>): T {
    return getValue(javaClass)!!.also { if (it is HasId) it.id = key }
}