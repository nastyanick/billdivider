package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.contacts.ContactsContract
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import dagger.Module
import dagger.Provides

@Module
class ContactsModule {

    @Provides
    fun provideContactsPresenter(presenter: ContactsPresenter): ContactsContract.Presenter = presenter
}