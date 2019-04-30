package com.nastynick.billdivider.di.presentaion

import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import com.nastynick.billdivider.presentation.main.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentersModule::class])
interface PresentationComponent {

    fun inject(fragment: FriendsFragment)

    fun inject(billsFragment: BillsFragment)

    fun injectMainActivity(activity: MainActivity)

    fun inject(contactsActivity: ContactsActivity)
}