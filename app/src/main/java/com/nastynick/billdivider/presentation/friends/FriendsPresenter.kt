package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import com.nastynick.billdivider.presentation.navigation.ContactsScreen
import com.nastynick.billdivider.presentation.navigation.FriendDetailsScreen
import com.nastynick.billdivider.presentation.util.StubUtil
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class FriendsPresenter @Inject constructor(
        private val getFriendsUseCase: GetFriendsUseCase,
        private val router: Router,
        private val stubUtil: StubUtil
) : BasePresenter<FriendView>() {

    override fun onFirstViewAttach() {
        getFriendsUseCase
                .getFriends()
                .subscribe(this::setFriends)
                .connect()
    }

    private fun setFriends(friends: List<Friend>) {
        viewState.showEmptyView(friends.isEmpty())
        viewState.setFriends(friends)
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
        stubUtil.showUnderDevelopmentYetMessage()
//        router.navigateTo(CreateFriendsScreen())
    }
}