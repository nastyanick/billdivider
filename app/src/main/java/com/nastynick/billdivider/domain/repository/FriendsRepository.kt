package com.nastynick.billdivider.domain.repository

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.data.objects.Friend
import io.reactivex.Observable

interface FriendsRepository {
    fun getFriends(): Observable<List<Friend>>
    fun saveFriendsFromContacts(contacts: List<Contact>): Observable<Friend>
}