package com.ngga_ring.repository.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ngga_ring.repository.common.Constant
import com.ngga_ring.repository.model.auth.Store
import com.ngga_ring.repository.model.product.Product
import com.ngga_ring.repository.repository.local.dao.ProductDao
import com.ngga_ring.repository.repository.local.dao.StoreDao

@Database(
    entities = [
        Product::class,
        Store::class,
    ], version = Constant.DB_VERSION, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
    abstract fun storeDao(): StoreDao
}
