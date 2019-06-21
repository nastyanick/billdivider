package com.nastynick.billdivider.di.presentaion

import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.billsummary.BillSummaryFragment
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import com.nastynick.billdivider.presentation.main.MainActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class])
interface PresentationComponent {

    fun inject(fragment: FriendsFragment)

    fun inject(billsFragment: BillsFragment)

    fun inject(activity: MainActivity)

    fun inject(contactsActivity: ContactsActivity)

    fun inject(friendActivity: FriendActivity)

    fun inject(billSummaryFragment: BillSummaryFragment)

    fun billWizardComponent(): BillWizardComponent
}