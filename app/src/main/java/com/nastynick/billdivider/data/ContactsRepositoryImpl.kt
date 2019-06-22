package com.nastynick.billdivider.data

import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import com.nastynick.billdivider.domain.repository.ContactsRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
        private val schedulers: SchedulersProvider
) : ContactsRepository {

    private var contactsCache: Observable<Contact>? = null

    override fun getContacts(): Single<List<Contact>> {
        return getContactsObservable()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .toList()
    }

    private fun getContactsObservable(): Observable<Contact> {
        return Observable.fromIterable(getDeviceContactsContacts())
                .also { contactsCache = it }
    }

    override fun searchContacts(filter: String): Observable<Contact> {
        return (contactsCache ?: getContactsObservable())
                .filter { contactContainsFilter(it, filter) }
    }

    private fun contactContainsFilter(contact: Contact, filter: String): Boolean {
        return contact.toString().contains(filter, true)
    }

    private fun getDeviceContactsContacts(): List<Contact> {
        return Contacts.getQuery().find().map { Contact.from(it) }
    }
}