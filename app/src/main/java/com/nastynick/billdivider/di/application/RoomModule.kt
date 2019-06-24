package com.nastynick.billdivider.di.application

import android.app.Application
import androidx.room.Room
import com.nastynick.billdivider.data.database.AppDatabase
import com.nastynick.billdivider.data.database.dao.BillDao
import com.nastynick.billdivider.data.database.dao.FriendDao
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @ApplicationScope
    @Provides
    fun providesDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(
                application,
                AppDatabase::class.java,
                "bill_divider_database"
        ).build()
    }

    @ApplicationScope
    @Provides
    fun providesFriendsDao(database: AppDatabase): FriendDao {
        return database.friendDao()
    }

    @ApplicationScope
    @Provides
    fun provideBillDao(database: AppDatabase): BillDao {
        return database.billDao()
    }
}
