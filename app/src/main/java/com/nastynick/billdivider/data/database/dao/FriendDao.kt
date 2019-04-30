package com.nastynick.billdivider.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nastynick.billdivider.data.database.objects.FriendEntity
import io.reactivex.Single

@Dao
interface FriendDao {

    @Query("SELECT * from friendentity")
    fun getAll(): List<FriendEntity>

    @Query("SELECT * from friendentity WHERE id=:friendId")
    fun get(friendId: Long): Single<FriendEntity>

    @Insert
    fun save(friend: FriendEntity)

    @Insert
    fun saveAll(friend: List<FriendEntity>)
}