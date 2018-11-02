package com.nastynick.billdivider.presentation.contacts

import android.support.v7.widget.SearchView
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.friends.SaveFriendsUseCase
import com.nastynick.billdivider.presentation.util.fromSearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ContactsPresenter @Inject constructor(
        private val view: ContactsContract.View,
        private val getContactsUseCase: GetContactsUseCase,
        private val saveFriendsUseCase: SaveFriendsUseCase,
        private val router: ContactsRouter
) : ContactsContract.Presenter {

    private val selectedContacts = mutableSetOf<Contact>()

    override fun onStart() {
        getContactsUseCase.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { contacts -> view.setContacts(contacts) }
    }

    override fun searchCreated(searchView: SearchView) {
        searchView.let(::fromSearchView)
                .let(getContactsUseCase::searchContacts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::setContacts)
    }

    override fun contactSelected(contact: Contact) {
        val contactId = contact.id ?: return

        if (selectedContacts.contains(contact)) {
            selectedContacts.remove(contact)
            view.clearContactSelection(contactId)
        } else {
            selectedContacts.add(contact)
            view.setContactSelected(contactId)
        }
        view.updateContact(contact)
    }

    override fun saveButtonClicked() {
        saveFriendsUseCase.saveFriendsFromContacts(selectedContacts.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { router.close() }
    }
}