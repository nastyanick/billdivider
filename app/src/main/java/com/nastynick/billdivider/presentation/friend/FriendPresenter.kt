package com.nastynick.billdivider.presentation.friend

import com.arellomobile.mvp.InjectViewState
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import com.nastynick.billdivider.presentation.base.BasePresenter
import javax.inject.Inject

@InjectViewState
class FriendPresenter @Inject constructor(
    private val getFriendsUseCase: GetFriendsUseCase
) : BasePresenter<FriendView>() {

    override fun onFirstViewAttach() {
        getFriendsUseCase
                .getFriend(0)
                .subscribe(viewState::setFriend)
                .connect()
    }
}