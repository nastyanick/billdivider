package com.nastynick.billdivider.di

import android.app.Application
import com.nastynick.billdivider.di.component.*
import com.nastynick.billdivider.di.module.ApplicationModule
import com.nastynick.billdivider.di.module.RoomModule

object DependencyResolver {
    private lateinit var applicationComponent: ApplicationComponent

    fun plusApplicationComponent(application: Application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(application))
                .roomModule(RoomModule())
                .build()
    }

    fun contactsComponent(): ContactsComponent {
        return applicationComponent.plusContactsComponent()
    }

    fun billsSubComponent(): BillsComponent {
        return applicationComponent.plusBillsComponent()
    }

    fun mainActivityComponent(): MainActivityComponent {
        return applicationComponent.plusMainActivityComponent()
    }

    fun friendsComponent(): FriendsComponent {
        return applicationComponent.plusFriendsComponent()
    }

}