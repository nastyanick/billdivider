package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.friends.SaveFriendsUseCase
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import com.nastynick.billdivider.presentation.contacts.ContactsRouter
import com.nastynick.billdivider.presentation.contacts.ContactsView
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

    private val view: ContactsView = mock()
    private val getContactsUseCase: GetContactsUseCase = mock()
    private val saveContactsUseCase: SaveFriendsUseCase = mock()
    private val router: ContactsRouter = mock()

    private lateinit var presenter: ContactsPresenter
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
    fun `get contacts should display contacts`() {
        doReturn(Single.just(contacts))
                .`when`(getContactsUseCase)
                .getContacts()

        presenter.onStart()

        testScheduler.triggerActions()

        verify(view).setContacts(contacts)
    }
}