package com.nastynick.billdivider.domain.repository.contacts

import com.nastynick.billdivider.data.objects.Contact
import io.reactivex.Observable

interface ContactsRepository {
    fun getContacts(): Observable<List<Contact>>
}