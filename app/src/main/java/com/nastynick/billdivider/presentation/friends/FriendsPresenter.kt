package com.nastynick.billdivider.presentation.friends

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@InjectViewState
class FriendsPresenter @Inject constructor(
        private val getFriendsUseCase: GetFriendsUseCase,
        private val router: FriendsRouter
) : MvpPresenter<FriendView>() {

    fun onStart() {
        getFriendsUseCase.getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::setFriends)
    }

    fun onFriendClick(friend: Friend) {
        router.openFriendsDetails(friend.id)
    }
}