package com.nastynick.billdivider.presentation.contacts

import android.Manifest
import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.usecase.contact.ContactsInteractor
import com.nastynick.billdivider.domain.usecase.friends.FriendsInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Observable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ContactsPresenter @Inject constructor(
        private val contactsInteractor: ContactsInteractor,
        private val friendsInteractor: FriendsInteractor,
        private val router: Router,
        private val rxPermissions: RxPermissions
) : BasePresenter<ContactsView>() {

    private val selectedContacts = mutableSetOf<Contact>()

    override fun onFirstViewAttach() {
        rxPermissions
                .request(Manifest.permission.READ_CONTACTS)
                .subscribe { granted -> if (granted) getContacts() }
                .connect()
    }

    private fun getContacts() {
        contactsInteractor
                .getContacts()
                .subscribe { contacts -> viewState.setContacts(contacts) }
                .connect()
    }

    fun searchCreated(searchSource: Observable<String>) {
        contactsInteractor.searchFrom(searchSource)
                .subscribe(viewState::setContacts)
                .connect()
    }

    fun contactSelected(contact: Contact) {
        val contactId = contact.id ?: return

        if (selectedContacts.contains(contact)) {
            selectedContacts.remove(contact)
            viewState.clearContactSelection(contactId)
        } else {
            selectedContacts.add(contact)
            viewState.setContactSelected(contactId)
        }
        viewState.updateContact(contact)
    }

    fun saveButtonClicked() {
        friendsInteractor
                .saveFriendsFromContacts(selectedContacts.toList())
                .subscribe { router.exit() }
                .connect()
    }
}