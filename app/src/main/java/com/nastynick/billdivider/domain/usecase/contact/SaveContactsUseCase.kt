package com.nastynick.billdivider.domain.usecase.contact

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import javax.inject.Inject

class SaveContactsUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {

    fun saveContacts(contacts: List<Contact>) = contactsRepository.saveContacts(contacts)
}