package com.nastynick.billdivider.presentation.friends

import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.domain.usecase.friends.GetFriendsUseCase
import com.nastynick.billdivider.presentation.Screens
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class FriendsPresenter @Inject constructor(
        private val view: FriendsContract.View,
        private val getFriendsUseCase: GetFriendsUseCase,
        private val router: Router
) : FriendsContract.Presenter {

    override fun onStart() {
        getFriendsUseCase.getFriends()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::setFriends)
    }

    override fun onFriendClick(friend: Friend) {
        router.navigateTo(Screens.FRIEND_DETAILS.name, friend.id)
    }

}