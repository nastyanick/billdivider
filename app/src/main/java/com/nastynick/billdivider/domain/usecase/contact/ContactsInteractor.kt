package com.nastynick.billdivider.domain.usecase.contact

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ContactsInteractor @Inject constructor(private val contactsRepository: ContactsRepository) {
    private val searchContactsDebounceTimeMillis = 100L

    fun getContacts() = contactsRepository.getContacts()

    fun searchFrom(searchSource: Observable<String>): Observable<List<Contact>> {
        return searchSource
                .debounce(searchContactsDebounceTimeMillis, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap { contactsRepository.searchContacts(it) }
    }
}