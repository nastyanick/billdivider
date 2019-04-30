package com.nastynick.billdivider.data

import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor() : ContactsRepository {

    private var contactsCache: List<Contact> = listOf()

    override fun getContacts(): Single<List<Contact>> {
        return Observable.fromIterable(getDeviceContactsContacts())
                .map(Contact.Companion::from)
                .toList()
                .doOnSuccess { contactsCache = it }
    }

    override fun searchContacts(filter: String): Observable<List<Contact>> {
        return Observable.fromIterable(contactsCache)
                .filter { contactContainsFilter(it, filter) }
                .toList()
                .toObservable()
    }

    private fun contactContainsFilter(contact: Contact, filter: String): Boolean {
        return contact.toString().contains(filter, true)
    }

    private fun getDeviceContactsContacts(): List<com.github.tamir7.contacts.Contact>? {
        return Contacts.getQuery().find()
    }
}