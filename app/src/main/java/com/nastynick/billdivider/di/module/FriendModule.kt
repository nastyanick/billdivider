package com.nastynick.billdivider.di.module

import com.nastynick.billdivider.presentation.friend.FriendActivity
import com.nastynick.billdivider.presentation.friend.FriendContact
import com.nastynick.billdivider.presentation.friend.FriendPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(FriendModule.FriendContractModule::class))
class FriendModule {

    @Module
    abstract class FriendContractModule {
        @Binds
        abstract fun provideFriendView(view: FriendActivity): FriendContact.View

        @Binds
        abstract fun provideFriendPresenter(presenter: FriendPresenter): FriendContact.Presenter
    }


    @Provides
    fun provideFriendId(view: FriendActivity): Long {
        return view.getFriendId()
    }
}