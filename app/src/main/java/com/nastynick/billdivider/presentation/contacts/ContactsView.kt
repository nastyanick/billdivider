package com.nastynick.billdivider.presentation.contacts

import com.arellomobile.mvp.MvpView
import com.nastynick.billdivider.data.objects.Contact

interface ContactsView : MvpView {
    fun setContacts(contacts: List<Contact>)

    fun setContactSelected(contactId: Long)
    fun clearContactSelection(contactId: Long)

    fun updateContact(contact: Contact)
}