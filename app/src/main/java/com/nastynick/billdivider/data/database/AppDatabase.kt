package com.nastynick.billdivider.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nastynick.billdivider.data.database.dao.FriendDao
import com.nastynick.billdivider.data.database.objects.FriendEntity

@Database(entities = [(FriendEntity::class)], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun friendDao(): FriendDao
}