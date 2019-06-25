package com.nastynick.billdivider.presentation.friend

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.domain.usecase.friends.FriendsInteractor
import com.nastynick.billdivider.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class FriendPresenter @Inject constructor(
    private val friendsInteractor: FriendsInteractor,
    private val friendId: Long
) : BasePresenter<FriendView>() {

    override fun onFirstViewAttach() {
        friendsInteractor
                .getFriend(friendId)
                .subscribe(viewState::setFriend)
                .connect()
    }
}