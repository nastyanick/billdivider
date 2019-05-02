package com.nastynick.billdivider.billdivider

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.friends.SaveFriendsUseCase
import com.nastynick.billdivider.presentation.contacts.ContactsContract
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import com.nastynick.billdivider.presentation.contacts.ContactsRouter
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test

class ContactsPresenterTest {

    private val view: ContactsContract.View = mock()
    private val getContactsUseCase: GetContactsUseCase = mock()
    private val saveContactsUseCase: SaveFriendsUseCase = mock()
    private val router: ContactsRouter = mock()
    private val contactsRepository: ContactsRepository = mock()

    private lateinit var presenter: ContactsContract.Presenter
    private lateinit var testScheduler: TestScheduler
    private val contacts = listOf(
            Contact(1, "Ivan", "23233", "ivan@mail.ru", null),
            Contact(2, "Petr", "1111", "petr@mail.ru", null)
    )

    @Before
    fun setup() {
        testScheduler = TestScheduler()
        presenter = ContactsPresenter(getContactsUseCase, saveContactsUseCase, router)
    }

//    @Test
    fun `get contact should display contacts`() {

        doReturn(Single.just(contacts))
                .`when`(getContactsUseCase)
                .getContacts()

        presenter.onStart(view)

        testScheduler.triggerActions()

        verify(view).updateContact(contacts[0])
    }

    @Test
    fun `contacts interactor search contacts`() {
        val getContactsUseCase = GetContactsUseCase(contactsRepository)
        val filterString = "Ivan"
        val filter = Observable.just(filterString)
        val searchResult = Observable.just(listOf(contacts[0]))

        whenever(contactsRepository.searchContacts(filterString)).thenReturn(searchResult)

        val testObserver = getContactsUseCase.searchContacts(filter).test()
        testObserver.awaitTerminalEvent()

        verify(contactsRepository).searchContacts(filterString)

        testObserver
                .assertNoErrors()
                .assertValueCount(1)
    }
}