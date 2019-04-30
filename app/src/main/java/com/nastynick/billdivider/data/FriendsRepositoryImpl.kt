package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.database.dao.FriendDao
import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.util.ContactFriendMapper
import com.nastynick.billdivider.data.util.FriendMapper
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(
    private val friendDao: FriendDao
) : FriendsRepository {

    override fun getFriends(): Single<List<Friend>> {
//        return Observable.fromIterable(friendDao.getAll())
//                .map(FriendMapper::fromEntity)
//                .toList()
        return Single.just(listOf())
    }

    // TODO remove extra convert from contact -> friednd -> entity
    override fun saveFriendsFromContacts(contacts: List<Contact>): Completable {
        return Completable
                .fromCallable {
                    friendDao.saveAll(contacts.map {
                        FriendMapper.fromData(
                                ContactFriendMapper.fromContact(it)
                        )
                    })
                }
    }

    override fun getFriend(friendId: Long): Single<Friend> {
        return friendDao.get(friendId)
                .map(FriendMapper::fromEntity)
    }

    private fun saveFriend(friend: Friend) {
        friendDao.save(FriendMapper.fromData(friend))
    }
}
