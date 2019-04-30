package com.nastynick.billdivider.domain.usecase.friends

import com.nastynick.billdivider.data.objects.Contact
import com.nastynick.billdivider.domain.repository.FriendsRepository
import javax.inject.Inject

class SaveFriendsUseCase @Inject constructor(
    private val friendsRepository: FriendsRepository
) {

    fun saveFriendsFromContacts(contacts: List<Contact>) = friendsRepository.saveFriendsFromContacts(contacts)
}