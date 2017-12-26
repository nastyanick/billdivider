package com.nastynick.billdivider.data

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import com.nastynick.billdivider.data.util.ContactFriendMapper
import com.nastynick.billdivider.data.util.firebaseSingleEventObservable
import com.nastynick.billdivider.data.util.mapToList
import com.nastynick.billdivider.domain.repository.FriendsRepository
import io.reactivex.Observable
import javax.inject.Inject

class FriendsRepositoryImpl @Inject constructor(private val databaseHolder: DatabaseHolder) : FriendsRepository {
    private val friendsDatabaseReference = "friends"

    override fun getFriends(): Observable<List<Friend>> {
        return firebaseSingleEventObservable(getFriendsQuery()) { it.mapToList(Friend::class.java) }
    }


    override fun saveFriendsFromContacts(contacts: List<Contact>): Observable<Friend> {
        return Observable.fromIterable(contacts)
                .map(ContactFriendMapper::fromContact)
                .doOnNext(this::saveFriend)

    }

    private fun saveFriend(it: Friend?) {
        getFriendsQuery().push().setValue(it)
    }

    private fun getFriendsQuery() = databaseHolder.reference.child(friendsDatabaseReference)
}

