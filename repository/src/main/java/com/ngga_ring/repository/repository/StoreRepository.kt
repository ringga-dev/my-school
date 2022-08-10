package com.ngga_ring.repository.repository

import com.ngga_ring.repository.model.auth.Store
import com.ngga_ring.repository.repository.local.AppDatabase
import com.ngga_ring.repository.repository.local.AuthPrefs

class StoreRepository(private val db: AppDatabase, private val authPrefs: AuthPrefs) {

    fun getList() = db.storeDao().getAll()
    fun clear() = db.storeDao().clear()
    fun count() = db.storeDao().countData()

    fun setSelectedStore(store: Store) {
        authPrefs.store = store
    }

}