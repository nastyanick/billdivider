package com.nastynick.billdivider.presentation.contacts

import android.support.v7.widget.SearchView
import com.nastynick.billdivider.data.objects.Contact

interface ContactsContract {

    interface View {
        fun setContacts(contacts: List<Contact>)

        fun setContactSelected(contactId: Long)
        fun clearContactSelection(contactId: Long)

        fun updateContact(contact: Contact)
    }

    interface Presenter {
        fun onStart()

        fun searchCreated(searchView: SearchView)

        fun contactSelected(contact: Contact)

        fun saveButtonClicked()
    }
}