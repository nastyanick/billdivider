package com.nastynick.billdivider.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nastynick.billdivider.data.database.dao.BillDao
import com.nastynick.billdivider.data.database.dao.FriendDao
import com.nastynick.billdivider.data.database.objects.BillEntity
import com.nastynick.billdivider.data.database.objects.FriendEntity

@Database(
        entities = [FriendEntity::class, BillEntity::class],
        version = AppDatabase.VERSION
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 1
    }

    abstract fun friendDao(): FriendDao

    abstract fun billDao(): BillDao
}