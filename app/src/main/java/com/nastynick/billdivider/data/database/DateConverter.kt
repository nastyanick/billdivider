package com.nastynick.billdivider.data.database

import androidx.room.TypeConverter
import java.util.*

//https://developer.android.com/training/data-storage/room/referencing-data
class DateConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}