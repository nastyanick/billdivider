package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.util.ContactFriendMapper
import com.nastynick.billdivider.data.util.firebaseEventSingle
import com.nastynick.billdivider.data.util.mapTo
import com.nastynick.billdivider.data.util.mapToList
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(private val databaseHolder: DatabaseHolder) : FriendsRepository {
    private val friendsDatabaseReference = "friends"

    override fun getFriends(): Single<List<Friend>> {
        return firebaseEventSingle(getFriendsQuery()) { it.mapToList(Friend::class.java) }
    }


    override fun saveFriendsFromContacts(contacts: List<Contact>): Completable {
        return Observable.fromIterable(contacts)
                .map(ContactFriendMapper::fromContact)
                .doOnNext(this::saveFriend)
                .ignoreElements()

    }

    override fun getFriend(friendId: String): Single<Friend> {
        return firebaseEventSingle(getFriendsQuery().child(friendId)) { it.mapTo(Friend::class.java) }
    }

    private fun saveFriend(it: Friend?) {
        getFriendsQuery().push().setValue(it)
    }

    private fun getFriendsQuery() = databaseHolder.reference.child(friendsDatabaseReference)
}

