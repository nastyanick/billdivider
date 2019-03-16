package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Contact
import io.reactivex.Observable
import io.reactivex.Single

interface ContactsRepository {
    fun getContacts(): Single<List<Contact>>
    fun searchContacts(filter: String): Observable <List<Contact>>
}