package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.ApplicationModule
import com.nastynick.billdivider.di.module.RoomModule
import dagger.Component

@Component(
        modules = [
            ApplicationModule::class,
            RoomModule::class
        ]
)
interface ApplicationComponent {

    fun plusContactsComponent(): ContactsComponent
    fun plusBillsComponent(): BillsComponent
    fun plusMainActivityComponent(): MainActivityComponent
    fun plusFriendsComponent(): FriendsComponent
}