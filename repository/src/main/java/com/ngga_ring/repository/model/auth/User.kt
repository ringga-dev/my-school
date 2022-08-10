package com.ngga_ring.repository.model.auth

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("id")
    var id: Long? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("photo_url")
    var photoUrl: String? = null
)