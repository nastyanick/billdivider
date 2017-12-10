package com.nastynick.billdivider.presentation.contacts

import com.nastynick.billdivider.data.objects.Contact

interface ContactsContract {

    interface View {
        fun setContacts(contacts: List<Contact>)
    }

    interface Presenter {
        fun onStart()
    }
}