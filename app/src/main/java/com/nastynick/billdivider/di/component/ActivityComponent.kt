package com.nastynick.billdivider.di.component

import com.nastynick.billdivider.di.module.BillWizardInfoModule
import com.nastynick.billdivider.di.module.ContactsModule
import com.nastynick.billdivider.di.module.FriendModule
import com.nastynick.billdivider.di.module.FriendsFragmentModule
import com.nastynick.billdivider.domain.repository.ContactsRepository
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import dagger.Subcomponent

@Subcomponent(modules = [
    ContactsModule::class,
    FriendsFragmentModule::class,
    FriendModule::class,
    BillWizardInfoModule::class,
    FriendsFragmentModule::class
]
)
interface ActivityComponent {
    fun injectContactsActivity(activity: ContactsActivity)

    fun injectFriendsActivity(activity: FriendActivity)

    fun injectBillWizardActivity(activity: BillWizardInfoActivity)

    fun getContactsRepository(): ContactsRepository
}
