package com.nastynick.billdivider.data.repository

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

    private val contactsObservable by lazy {
        Observable
                .fromIterable(Contacts.getQuery().find())
                .map { Contact.from(it) }
    }

    override fun getContacts(): Single<List<Contact>> {
        return contactsObservable
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .toList()
    }

    override fun searchContacts(filter: String): Observable<Contact> {
        return contactsObservable
                .filter { contactContainsFilter(it, filter) }
    }

    private fun contactContainsFilter(contact: Contact, filter: String): Boolean {
        return contact.toString().contains(filter, true)
    }
}