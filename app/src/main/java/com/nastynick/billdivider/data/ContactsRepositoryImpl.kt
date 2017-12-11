package com.nastynick.billdivider.data

import com.github.tamir7.contacts.Contacts
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
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
        return Contact(
                name = contact.displayName,
                phone = contact.phoneNumbers.elementAtOrNull(0)?.normalizedNumber,
                email = contact.emails.elementAtOrNull(0)?.address,
                photoUri = contact.photoUri
        )
    }
}