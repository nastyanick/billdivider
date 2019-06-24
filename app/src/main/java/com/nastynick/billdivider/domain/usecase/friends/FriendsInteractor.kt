package com.nastynick.billdivider.domain.usecase.friends

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.FriendsRepository
import javax.inject.Inject

class FriendsInteractor @Inject constructor(private val friendsRepository: FriendsRepository) {

    fun getFriends() = friendsRepository.getFriends()

    fun getFriend(friendId: Long) = friendsRepository.getFriend(friendId)

    fun saveFriendsFromContacts(contacts: List<Contact>) = friendsRepository.saveFriendsFromContacts(contacts)

}