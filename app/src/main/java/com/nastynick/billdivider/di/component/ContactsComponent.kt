package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.ContactsModule
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import dagger.Subcomponent

@Subcomponent(modules = [ContactsModule::class])
interface ContactsComponent {
    fun inject(contactsActivity: ContactsActivity)
}