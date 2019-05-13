package com.nastynick.billdivider.domain.usecase.contact

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GetContactsUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {
    private val searchContactsDebounceTimeMillis = 100L

    fun getContacts() = contactsRepository.getContacts()

    fun searchContacts(filter: Observable<String>): Single<List<Contact>> {
        return filter
                .debounce(searchContactsDebounceTimeMillis, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .flatMap { contactsRepository.searchContacts(it) }
                .toList()
    }
}