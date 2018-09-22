package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.util.ContactFriendMapper
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


//TODO implemet repository
class FriendsRepositoryImpl @Inject constructor() :
    FriendsRepository {

    override fun getFriends(): Single<List<Friend>> {
        return Single.just(listOf())
    }


    override fun saveFriendsFromContacts(contacts: List<Contact>): Completable {
        return Observable.fromIterable(contacts)
            .map(ContactFriendMapper::fromContact)
            .doOnNext(this::saveFriend)
            .ignoreElements()

    }

    override fun getFriend(friendId: String): Single<Friend> {
        return Single.just(Friend())
    }

    private fun saveFriend(it: Friend?) {
    }
}

