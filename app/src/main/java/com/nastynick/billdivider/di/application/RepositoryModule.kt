package com.nastynick.billdivider.di.application

import com.nastynick.billdivider.data.BillsRepositoryImpl
import com.nastynick.billdivider.data.ContactsRepositoryImpl
import com.nastynick.billdivider.data.FriendsRepositoryImpl
import com.nastynick.billdivider.domain.repository.BillsRepository
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.repository.FriendsRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @ApplicationScope
    @Provides
    fun provideBillsRepository(billsRepository: BillsRepositoryImpl): BillsRepository = billsRepository

    @ApplicationScope
    @Provides
    fun provideContactsRepository(contactsRepository: ContactsRepositoryImpl): ContactsRepository = contactsRepository

    @ApplicationScope
    @Provides
    fun provideFriendsRepository(friendsRepository: FriendsRepositoryImpl): FriendsRepository = friendsRepository
}