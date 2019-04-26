package com.nastynick.billdivider.presentation.contacts

import androidx.appcompat.widget.SearchView
import com.nastynick.billdivider.data.objects.Contact

interface ContactsContract {

    interface View {
        fun setContacts(contacts: List<Contact>)

        fun setContactSelected(contactId: Long)
        fun clearContactSelection(contactId: Long)

        fun updateContact(contact: Contact)
    }

    interface Presenter {
        fun onStart(view: View)

        fun searchCreated(searchView: SearchView)

        fun contactSelected(contact: Contact)

        fun saveButtonClicked()
    }
}