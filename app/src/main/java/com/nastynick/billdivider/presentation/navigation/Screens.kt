package com.nastynick.billdivider.presentation.navigation

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import com.nastynick.billdivider.presentation.bills.BillsFragment
import com.nastynick.billdivider.presentation.billsummary.BillSummaryFragment
import com.nastynick.billdivider.presentation.billwizard.details.BillWizardDetailsFragment
import com.nastynick.billdivider.presentation.billwizard.flow.BillWizardFlowActivity
import com.nastynick.billdivider.presentation.billwizard.position.BillWizardPositionFragment
import com.nastynick.billdivider.presentation.billwizard.positions.BillWizardPositionsFragment
import com.nastynick.billdivider.presentation.billwizard.summary.BillWizardSummaryFragment
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.friends.FriendsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class FriendDetailsScreen(private val friendId: Long) : SupportAppScreen() {
    override fun getActivityIntent(context: Context): Intent {
        return FriendActivity.getIntent(context, friendId)
    }
}

class ContactsScreen : SupportAppScreen() {
    override fun getActivityIntent(context: Context): Intent {
        return ContactsActivity.getIntent(context)
    }
}

class CreateFriendsScreen : SupportAppScreen()

class BillWizardFlowScreen : SupportAppScreen() {
    override fun getActivityIntent(context: Context): Intent {
        return BillWizardFlowActivity.getIntent(context)
    }
}

class BillWizardDetailsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillWizardDetailsFragment.getInstance()
    }
}

class BillWizardPositionScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillWizardPositionFragment.getInstance()
    }
}

class BillWizardPositionsScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillWizardPositionsFragment.getInstance()
    }
}

class BillWizardSummaryScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return BillWizardSummaryFragment.getInstance()
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
