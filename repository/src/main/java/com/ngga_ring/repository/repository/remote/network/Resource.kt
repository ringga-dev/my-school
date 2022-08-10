package com.ngga_ring.repository.repository.remote.network


sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    class Success<T>(val data: T) : Resource<T>()
    class Error(val message: String? = null) : Resource<Nothing>()
}