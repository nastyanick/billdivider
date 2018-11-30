package com.nastynick.billdivider.di.module

import android.app.Application
import android.content.Context
import com.nastynick.billdivider.data.BillsRepositoryImpl
import com.nastynick.billdivider.data.ContactsRepositoryImpl
import com.nastynick.billdivider.data.FriendsRepositoryImpl
import com.nastynick.billdivider.domain.repository.BillsRepository
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.repository.FriendsRepository
import dagger.Provides
import dagger.Module


@Module
class ApplicationModule(val application: Application) {

    @Provides
    fun provideContext(): Context = this.application

    @Provides
    fun provideBillsRepository(billsRepository: BillsRepositoryImpl): BillsRepository = billsRepository

    @Provides
    fun provideContactsRepository(contactsRepository: ContactsRepositoryImpl): ContactsRepository = contactsRepository

    @Provides
    fun provideFriendsRepository(friendsRepository: FriendsRepositoryImpl): FriendsRepository = friendsRepository
}