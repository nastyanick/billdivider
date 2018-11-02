package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface FriendsRepository {
    fun getFriends(): Observable<List<Friend>>
    fun saveFriendsFromContacts(contacts: List<Contact>): Completable
    fun getFriend(friendId: Long): Observable<Friend>
}