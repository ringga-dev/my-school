package com.ngga_ring.repository.model.auth

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("access_token")
    var accessToken: String? = null,
    @SerializedName("expires_in")
    var expiresIn: Int? = null,
    @SerializedName("refresh_token")
    var refreshToken: String? = null,
    @SerializedName("token_type")
    var tokenType: String? = null
)