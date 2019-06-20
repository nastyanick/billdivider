package com.nastynick.billdivider.presentation.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.billsummary.BillSummaryFragment
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendDetailsScreen(private val friendId: Long) : SupportAppScreen() {
    override fun getActivityIntent(context: Context): Intent {
        return FriendActivity.getIntent(context, friendId)
    }
}

class ContactsScreen : SupportAppScreen()

class BillWizardScreen : SupportAppScreen() {
    override fun getActivityIntent(context: Context): Intent {
        return BillWizardInfoActivity.getIntent(context)
    }
}

class BillSummaryScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillSummaryFragment.getInstance()
    }
}

class BillsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillsFragment.getInstance()
    }
}

class FriendsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return FriendsFragment.getInstance()
    }
}
