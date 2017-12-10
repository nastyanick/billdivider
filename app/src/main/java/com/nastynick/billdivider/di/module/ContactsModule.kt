package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.contacts.ContactsContract
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ContactsModule {

    @Binds
    abstract fun provideContactsView(view: ContactsActivity): ContactsContract.View

    @Binds
    abstract fun provideContactsPresenter(presenter: ContactsPresenter): ContactsContract.Presenter
}