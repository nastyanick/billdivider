package com.nastynick.billdivider.data

import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.contacts.ContactsRepository
import io.reactivex.Observable
import javax.inject.Inject


class ContactsRepositoryImpl @Inject constructor() : ContactsRepository {
    override fun getContacts(): Observable<List<Contact>> {
        return Observable.fromIterable(getDeviceContactsContacts())
                .map(this::map)
                .toList()
                .toObservable()
    }

    private fun getDeviceContactsContacts(): List<com.github.tamir7.contacts.Contact>? {
        return Contacts.getQuery().find()
    }

    private fun map(contact: com.github.tamir7.contacts.Contact): Contact {
        return Contact(contact.displayName, contact.photoUri)
    }
}