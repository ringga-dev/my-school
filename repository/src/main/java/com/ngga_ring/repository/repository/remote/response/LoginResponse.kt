package com.ngga_ring.repository.repository.remote.response


import com.google.gson.annotations.SerializedName
import com.ngga_ring.repository.model.auth.Store
import com.ngga_ring.repository.model.auth.Token
import com.ngga_ring.repository.model.auth.User

data class LoginResponse(
    @SerializedName("stores")
    var stores: List<Store>? = null,
    @SerializedName("token")
    var token: Token? = null,
    @SerializedName("user")
    var user: User? = null,
    @SerializedName("error")
    var error: String?,
)