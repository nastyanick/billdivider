package com.nastynick.billdivider.domain.usecase.contacts

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.usecase.contact.ContactsInteractor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Test

class ContactsInteractorTest {
    private val contactsRepository: ContactsRepository = mock()

    @Test
    fun `contacts use case search contacts`() {
        val contacts = listOf(
                Contact(1, "Ivan", "23233", "ivan@mail.ru", null),
                Contact(2, "Petr", "1111", "petr@mail.ru", null)
        )
        val getContactsUseCase = ContactsInteractor(contactsRepository)
        val filterString = "Ivan"
        val filter = Observable.just(filterString)
        val searchResult = Observable.just(contacts[0])

        whenever(contactsRepository.searchContacts(filterString)).thenReturn(searchResult)

        val testObserver = getContactsUseCase.searchContacts(filter).test()
        testObserver.awaitTerminalEvent()

        verify(contactsRepository).searchContacts(filterString)

        testObserver
                .assertNoErrors()
                .assertValueCount(1)
    }
}