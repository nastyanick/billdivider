package com.nastynick.billdivider.presentation.friend

import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FriendPresenter @Inject constructor(
    private val view: FriendContact.View,
    private val friendId: Long,
    private val getFriendsUseCase: GetFriendsUseCase
) : FriendContact.Presenter {

    override fun onStart() {
        getFriendsUseCase.getFriend(friendId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::setFriend)
    }
}