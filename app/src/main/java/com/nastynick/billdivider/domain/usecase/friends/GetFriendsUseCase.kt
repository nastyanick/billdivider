package com.nastynick.billdivider.domain.usecase.friends

import com.nastynick.billdivider.domain.repository.FriendsRepository
import javax.inject.Inject

class GetFriendsUseCase @Inject constructor(private val friendsRepository: FriendsRepository) {

    fun getFriends() = friendsRepository.getFriends()
}