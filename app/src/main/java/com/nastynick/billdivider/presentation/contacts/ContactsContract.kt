package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.data.objects.Contact

interface ContactsContract {

    interface View {
        fun setContacts(contacts: List<Contact>)

        fun setContactSelected(contactId: Long)
        fun clearContactSelection(contactId: Long)

        fun updateContact(contact: Contact)

        //TODO replace with Cicerone
        fun close()
    }

    interface Presenter {
        fun onStart()

        fun contactSelected(contact: Contact)

        fun saveButtonClicked()
    }
}