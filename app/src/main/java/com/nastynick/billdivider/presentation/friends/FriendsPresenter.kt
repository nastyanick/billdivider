package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.domain.usecase.friends.FriendsInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.ContactsScreen
import com.nastynick.billdivider.presentation.navigation.FriendDetailsScreen
import com.nastynick.billdivider.presentation.util.StubUtil
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class FriendsPresenter @Inject constructor(
        private val friendsInteractor: FriendsInteractor,
        private val router: Router,
        private val stubUtil: StubUtil
) : BasePresenter<FriendView>() {

    override fun onFirstViewAttach() {
        friendsInteractor
                .getFriends()
                .subscribe(this::setFriends)
                .connect()
    }

    private fun setFriends(friends: List<Friend>) {
        val isEmpty = friends.isEmpty()
        if (!isEmpty) {
            viewState.showFriends(friends)
        }
        viewState.showEmptyView(isEmpty)
    }

    fun onFriendClick(friend: Friend) {
        friend.id?.let { router.navigateTo(FriendDetailsScreen(it)) }
    }

    fun onAddFriendClick() {
        viewState.openFriendAddingMenu()
    }

    fun onAddFriendFromContactsClick() {
        router.navigateTo(ContactsScreen())
        viewState.closeFriendAddingMenu()
    }

    fun onCreateFriendClick() {
        stubUtil.showUnderDevelopmentMessage()
        viewState.closeFriendAddingMenu()
//        router.navigateTo(CreateFriendsScreen())
    }

    fun onStart() {
        onFirstViewAttach()
    }
}