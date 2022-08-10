package com.ngga_ring.repository.repository.local.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.ngga_ring.repository.model.product.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Insert(onConflict = REPLACE)
    fun insert(data: Product)

    @Insert(onConflict = REPLACE)
    fun insert(data: List<Product>)

    @Update
    fun update(data: Product)

    @Update
    fun update(data: List<Product>)

    @Delete
    fun delete(data: Product)

    @Query("SELECT * from Product ORDER BY id DESC")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * from Product WHERE id = :id LIMIT 1")
    fun getOne(id: Int): Flow<Product?>

    @Query("SELECT * from Product WHERE id = :id LIMIT 1")
    fun getOneNonFlow(id: Int): Product?

    @Query("SELECT * from Product WHERE name LIKE :queryString")
    fun search(queryString: String): Flow<List<Product>>

    @Query("DELETE FROM Product")
    fun clear()

    @Query("SELECT COUNT(id) FROM Product")
    fun countData(): Flow<Int>
}