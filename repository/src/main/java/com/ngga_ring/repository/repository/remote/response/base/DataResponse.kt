package com.ngga_ring.repository.repository.remote.response.base

data class DataResponse<T>(
    var data: T? = null,
    var error: String? = null,
)