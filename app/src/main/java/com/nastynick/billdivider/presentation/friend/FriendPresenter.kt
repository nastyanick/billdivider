package com.nastynick.billdivider.presentation.friend

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class FriendPresenter @Inject constructor(
        private val getFriendsUseCase: GetFriendsUseCase
) : MvpPresenter<FriendView>() {

    fun onStart() {
        getFriendsUseCase.getFriend(0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::setFriend)
    }
}