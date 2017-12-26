package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FriendsPresenter @Inject constructor(private val view: FriendsContract.View,
                                           private val getFriendsUseCase: GetFriendsUseCase
) : FriendsContract.Presenter {

    override fun onStart() {
        getFriendsUseCase.getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::setFriends)
    }

}