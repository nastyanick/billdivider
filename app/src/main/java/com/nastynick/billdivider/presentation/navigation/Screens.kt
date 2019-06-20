package com.nastynick.billdivider.presentation.navigation

import android.content.Context
import android.content.Intent
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
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