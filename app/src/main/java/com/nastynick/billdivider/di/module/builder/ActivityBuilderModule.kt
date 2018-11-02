package com.nastynick.billdivider.di.module.builder

import com.nastynick.billdivider.di.annotation.scope.ActivityScope
import com.nastynick.billdivider.di.module.*
import com.nastynick.billdivider.presentation.authorization.SplashActivity
import com.nastynick.billdivider.presentation.billwizard.BillWizardInfoActivity
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
@ActivityScope
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    @ActivityScope
    abstract fun buildRootActivity(): MainActivity

    @ContributesAndroidInjector(modules = arrayOf(ContactsModule::class))
    @ActivityScope
    abstract fun buildContactsActivity(): ContactsActivity

    @ContributesAndroidInjector(modules = arrayOf(FriendModule::class))
    abstract fun buildFriendActivity(): FriendActivity

    @ContributesAndroidInjector(modules = arrayOf(BillWizardInfoModule::class))
    abstract fun buildBillWizardInfoActivity(): BillWizardInfoActivity
}