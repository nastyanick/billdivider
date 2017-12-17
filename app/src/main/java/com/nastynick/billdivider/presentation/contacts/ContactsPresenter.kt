package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.usecase.contact.GetContactsUseCase
import com.nastynick.billdivider.domain.usecase.contact.SaveContactsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ContactsPresenter @Inject constructor(
        private val view: ContactsContract.View,
        private val getContactsUseCase: GetContactsUseCase,
        private val saveContactsUseCase: SaveContactsUseCase
) : ContactsContract.Presenter {

    private val selectedContacts = mutableSetOf<Contact>()

    override fun onStart() {
        getContactsUseCase.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { contacts -> view.setContacts(contacts) }
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
        saveContactsUseCase.saveContacts(selectedContacts.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete { view.close() }
                .subscribe()
    }
}