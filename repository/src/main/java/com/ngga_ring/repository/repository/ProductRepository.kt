package com.ngga_ring.repository.repository

import com.ngga_ring.core.extension.debugPrintStackTrace
import com.ngga_ring.repository.common.Helper
import com.ngga_ring.repository.model.product.Product
import com.ngga_ring.repository.repository.local.AppDatabase
import com.ngga_ring.repository.repository.local.AuthPrefs
import com.ngga_ring.repository.repository.remote.network.Resource
import com.ngga_ring.repository.repository.remote.request.GetProductRequest
import com.ngga_ring.repository.repository.remote.service.ProductService
import kotlinx.coroutines.flow.flow

class ProductRepository(private val db: AppDatabase, private val remote: ProductService, private val pref: AuthPrefs) {

    fun getProduct(deviceId: String, page: Int) = flow {
        emit(Resource.Loading)
        val request = GetProductRequest(pref.user!!.id!!, pref.store!!.urlId!!, deviceId, "", page)
        try {
            val response = remote.getProduct(request.storeUrl, Helper.getLocale(), request)
            if (response.error.isNullOrBlank()) {
                emit(Resource.Success(response))
            } else {
                emit(Resource.Error(response.error!!))
            }
        } catch (e: Exception) {
            e.debugPrintStackTrace()
            emit(Resource.Error())
        }
    }

    /**************************** Local **************************/
    fun getAllProduct() = db.productDao().getAll()
    fun insertProduct(body: Product) = db.productDao().insert(body)
    fun insertProduct(body: List<Product>) = db.productDao().insert(body)
    fun updateProduct(body: Product) = db.productDao().update(body)
    fun clearProduct() = db.productDao().clear()
    fun deleteProduct(data: Product) = db.productDao().delete(data)
}