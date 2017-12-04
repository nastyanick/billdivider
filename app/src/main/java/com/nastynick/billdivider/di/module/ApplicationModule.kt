package com.nastynick.billdivider.di.module

import android.app.Application
import android.content.Context
import com.nastynick.billdivider.data.BillsRepositoryImpl
import com.nastynick.billdivider.domain.repository.bills.BillsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun provideBillsRepository(billsRepositoryImpl: BillsRepositoryImpl): BillsRepository
}