package com.ngga_ring.repository.repository.remote.request

/**
 * Created by Tisto on 1/20/2021.
 */

data class ProductRequest(
    val id: Int = 0,
    var price: String = "",
    val buyPrice: String = "",
    val name: String = "",
    val fileName: String = "",
    val deskripsi: String = "",
    val storeId: Int = 0,
    val categoryId: Int = 0,
    val unitId: Int = 0,
    val barcode: String = "",
)