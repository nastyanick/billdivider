package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.bills.BillsContract
import com.nastynick.billdivider.presentation.bills.BillsPresenter
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoContract
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoPresenter
import com.nastynick.billdivider.presentation.contacts.ContactsContract
import com.nastynick.billdivider.presentation.contacts.ContactsPresenter
import com.nastynick.billdivider.presentation.friend.FriendContact
import com.nastynick.billdivider.presentation.friend.FriendPresenter
import com.nastynick.billdivider.presentation.friends.FriendsContract
import com.nastynick.billdivider.presentation.friends.FriendsPresenter
import com.nastynick.billdivider.presentation.main.MainContract
import com.nastynick.billdivider.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class PresentersModule {

    @Provides
    fun providePresenter(presenter: BillsPresenter): BillsContract.Presenter = presenter

    @Provides
    fun provideBillWizardInfoPresenter(presenter: BillWizardInfoPresenter): BillWizardInfoContract.Presenter = presenter

    @Provides
    fun provideContactsPresenter(presenter: ContactsPresenter): ContactsContract.Presenter = presenter

    @Provides
    fun provideFriendPresenter(presenter: FriendPresenter): FriendContact.Presenter = presenter

    @Provides
    fun provideFriendsPresenter(presenter: FriendsPresenter): FriendsContract.Presenter = presenter

    @Provides
    fun provideRootPresenter(presenter: MainPresenter): MainContract.Presenter = presenter
}