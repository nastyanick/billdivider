package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.contacts.ContactsContract
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import dagger.Module
import dagger.Provides

@Module
class ContactsModule(val activity: ContactsActivity) {

    @Provides
    fun provideContactsView(): ContactsContract.View = activity

    @Provides
    fun provideContactsPresenter(presenter: ContactsPresenter): ContactsContract.Presenter = presenter
}