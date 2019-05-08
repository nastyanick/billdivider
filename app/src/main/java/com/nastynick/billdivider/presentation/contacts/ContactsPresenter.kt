package com.nastynick.billdivider.presentation.contacts

import androidx.appcompat.widget.SearchView
import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.friends.SaveFriendsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.util.fromSearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class ContactsPresenter @Inject constructor(
        private val getContactsUseCase: GetContactsUseCase,
        private val saveFriendsUseCase: SaveFriendsUseCase,
        private val router: ContactsRouter
) : BasePresenter<ContactsView>() {

    private val selectedContacts = mutableSetOf<Contact>()

    fun onStart() {
        getContactsUseCase
                .getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { contacts -> viewState.setContacts(contacts) }
                .connect()
    }

    fun searchCreated(searchView: SearchView) {
        searchView
                .let(::fromSearchView)
                .let(getContactsUseCase::searchContacts)
                .observeOn(AndroidSchedulers.mainThread())
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
        saveFriendsUseCase
                .saveFriendsFromContacts(selectedContacts.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { router.close() }
                .connect()
    }
}