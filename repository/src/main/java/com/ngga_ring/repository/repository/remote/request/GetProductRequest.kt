package com.ngga_ring.repository.repository.remote.request

import com.google.gson.annotations.SerializedName

data class GetProductRequest(
    @SerializedName("uid") val userId: Long,
    @SerializedName("storeUrl") val storeUrl: String,
    @SerializedName("device_id") val deviceId: String,
    @SerializedName("lsync") val lastSync: String,
    @SerializedName("page") val page: Int,
)
