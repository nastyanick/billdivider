package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.BillDividerApplication
import com.nastynick.billdivider.di.module.*
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.main.MainActivity
import dagger.Component

@Component(
        modules = [
            ApplicationModule::class,
            RoomModule::class,
            MainActivityModule::class
//            ,
//            ContactsModule::class,
//            FriendsFragmentModule::class,
//            FriendModule::class,
//            BillWizardInfoModule::class,
//            FriendsFragmentModule::class
        ]
)
interface ApplicationComponent {

    fun injectApplication(application: BillDividerApplication)

    fun injectMainActivity(activity: MainActivity)

}