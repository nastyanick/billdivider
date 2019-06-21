package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.contacts.ContactsActivity
import com.nastynick.billdivider.presentation.navigation.ContactsScreen
import com.nastynick.billdivider.presentation.navigation.CreateFriendsScreen
import com.nastynick.billdivider.presentation.navigation.FriendDetailsScreen
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class FriendsPresenter @Inject constructor(
        private val getFriendsUseCase: GetFriendsUseCase,
        private val router: Router
) : BasePresenter<FriendView>() {

    fun onStart() {
        getFriendsUseCase
                .getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::setFriends)
                .connect()
    }

    fun onFriendClick(friend: Friend) {
        friend.id?.let { router.navigateTo(FriendDetailsScreen(it)) }
    }

    fun onAddFriendClick() {
        viewState.openFriendAddingMenu()
    }

    fun onAddFriendFromContactsClick() {
        router.navigateTo(ContactsScreen())
    }

    fun onCreateFriendClick() {
        router.navigateTo(CreateFriendsScreen())
    }
}