package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.database.dao.FriendDao
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.util.ContactFriendMapper
import com.nastynick.billdivider.data.util.FriendMapper
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class FriendsRepositoryImpl @Inject constructor(
        private val friendDao: FriendDao
) : FriendsRepository {

    override fun getFriends(): Observable<List<Friend>> {
        return Observable
                .fromCallable { friendDao.getAll().map(FriendMapper::fromEntity) }
                .subscribeOn(Schedulers.computation())
    }


    override fun saveFriendsFromContacts(contacts: List<Contact>): Completable {
        return Observable.fromIterable(contacts)
                .map(ContactFriendMapper::fromContact)
                .doOnNext(this::saveFriend)
                .ignoreElements()
    }

    override fun getFriend(friendId: Long): Observable<Friend> {
        return friendDao.get(friendId)
                .let(FriendMapper::fromEntity)
                .let { Observable.just(it) }
    }

    private fun saveFriend(friend: Friend) {
        friendDao.save(FriendMapper.fromData(friend))
    }
}

