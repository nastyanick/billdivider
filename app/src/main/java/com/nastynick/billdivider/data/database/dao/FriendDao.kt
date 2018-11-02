package com.nastynick.billdivider.data.database.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
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