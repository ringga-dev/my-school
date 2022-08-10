package com.ngga_ring.myschool.activity.storelogin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ngga_ring.repository.model.auth.Store
import com.ngga_ring.repository.repository.AuthRepository
import com.ngga_ring.repository.repository.StoreRepository

class StoreViewModel(private val storeRepository: StoreRepository, private val authRepository: AuthRepository) : ViewModel() {

    fun getStoreList() = storeRepository.getList().asLiveData()
    fun setSelectedStore(store: Store) = storeRepository.setSelectedStore(store)
    fun getUserName() = authRepository.getUserName()

}