package com.nastynick.billdivider.di.module

import android.app.Application
import android.content.Context
import com.nastynick.billdivider.data.BillsRepositoryImpl
import com.nastynick.billdivider.data.ContactsRepositoryImpl
import com.nastynick.billdivider.data.FriendsRepositoryImpl
import com.nastynick.billdivider.domain.repository.BillsRepository
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.domain.repository.FriendsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun provideBillsRepository(billsRepository: BillsRepositoryImpl): BillsRepository

    @Binds
    abstract fun provideContactsRepository(contactsRepository: ContactsRepositoryImpl): ContactsRepository

    @Binds
    abstract fun provideFriendsRepository(friendsRepository: FriendsRepositoryImpl): FriendsRepository
}