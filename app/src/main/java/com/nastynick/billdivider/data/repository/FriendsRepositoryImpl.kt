package com.nastynick.billdivider.data.repository

import com.nastynick.billdivider.data.database.dao.FriendDao
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.schedulers.SchedulersProvider
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(
        private val friendDao: FriendDao,
        private val schedulers: SchedulersProvider
) : FriendsRepository {

    override fun getFriends(): Single<List<Friend>> {
        return Single
                .fromCallable { friendDao.getAll().map { Friend.fromEntity(it) } }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }

    override fun saveFriendsFromContacts(contacts: List<Contact>): Completable {
        return Completable
                .fromCallable {
                    friendDao.saveAll(contacts.map(Friend.Companion::toEntity))
                }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }

    override fun getFriend(friendId: Long): Single<Friend> {
        return friendDao.get(friendId)
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .map(Friend.Companion::fromEntity)
    }

    private fun saveFriend(friend: Friend) {
        friendDao.save(Friend.toEntity(friend))
    }
}
