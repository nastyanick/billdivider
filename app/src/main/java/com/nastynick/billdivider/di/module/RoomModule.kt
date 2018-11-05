package com.nastynick.billdivider.di.module

import androidx.room.Room
import android.content.Context
import com.nastynick.billdivider.data.database.AppDatabase
import com.nastynick.billdivider.data.database.dao.FriendDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(
            context,
            AppDatabase::class.java,
            "bill_divider_database"
        ).build()
    }

    @Provides
    @Singleton
    fun providesFriendsRepository(database: AppDatabase): FriendDao {
        return database.friendDao()
    }
}
