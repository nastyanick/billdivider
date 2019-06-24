package com.nastynick.billdivider.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nastynick.billdivider.data.database.objects.BillEntity
import io.reactivex.Single

@Dao
interface BillDao {

    @Query("SELECT * from billentity")
    fun getAll(): List<BillEntity>

    @Query("SELECT * from billentity WHERE id=:billId")
    fun get(billId: Long): Single<BillEntity>

    @Insert
    fun save(bill: BillEntity)
}