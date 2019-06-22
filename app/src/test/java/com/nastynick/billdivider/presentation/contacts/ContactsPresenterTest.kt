package com.nastynick.billdivider.presentation.contacts

import android.Manifest
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.friends.SaveFriendsUseCase
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Test
import ru.terrakok.cicerone.Router

class ContactsPresenterTest {

    private val view: ContactsView = mock()

    private val getContactsUseCase: GetContactsUseCase = mock()
    private val saveContactsUseCase: SaveFriendsUseCase = mock()
    private val router: Router = mock()
    private val rxPermissions: RxPermissions = mock()

    private val presenter = ContactsPresenter(
            getContactsUseCase,
            saveContactsUseCase,
            router,
            rxPermissions
    )

    private val contacts = listOf(
            Contact(1, "Ivan", "23233", "ivan@mail.ru", null),
            Contact(2, "Petr", "1111", "petr@mail.ru", null)
    )

    @Test
    fun `attach view display contacts`() {
        whenever(getContactsUseCase.getContacts())
                .thenReturn(Single.just(contacts))

        whenever(rxPermissions.request(Manifest.permission.READ_CONTACTS))
                .thenReturn(Observable.just(true))

        presenter.attachView(view)

        verify(view).setContacts(contacts)
    }
}