package com.nastynick.billdivider.domain.usecase.contact

import com.nastynick.billdivider.domain.repository.contacts.ContactsRepository
import javax.inject.Inject


class GetContactsUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {

    fun getContacts() = contactsRepository.getContacts()
}