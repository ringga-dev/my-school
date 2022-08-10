package com.ngga_ring.repository.repository.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ngga_ring.repository.model.auth.Store
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreDao {

    @Insert(onConflict = REPLACE)
    fun insert(data: Store)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<Store>)

    @Delete
    fun delete(data: Store)

    @Query("SELECT * from Store ORDER BY id DESC")
    fun getAll(): Flow<List<Store>>

    @Query("DELETE FROM Store")
    fun clear()

    @Query("SELECT COUNT(id) FROM Store")
    fun countData(): Flow<Int>
}