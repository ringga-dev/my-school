package com.ngga_ring.repository.repository.remote.service

import com.ngga_ring.repository.repository.remote.request.GetProductRequest
import com.ngga_ring.repository.repository.remote.response.ProductResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductService {

    @POST("api/pos/v4/{storeUrl}/{locale}/product/sync")
    suspend fun getProduct(
        @Path("storeUrl") storeUrl: String,
        @Path("locale") locale: String,
        @Body() data: GetProductRequest
    ): ProductResponse

}