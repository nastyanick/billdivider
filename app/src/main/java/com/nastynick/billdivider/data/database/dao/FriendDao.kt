package com.nastynick.billdivider.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nastynick.billdivider.data.database.objects.FriendEntity

@Dao
interface FriendDao {

    @Query("SELECT * from friendentity")
    fun getAll(): List<FriendEntity>

    @Query("SELECT * from friendentity WHERE id=:friendId")
    fun get(friendId: Long): FriendEntity

    @Insert
    fun save(friend: FriendEntity)

}