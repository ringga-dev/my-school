package com.ngga_ring.repository.repository.remote.request

import com.google.gson.annotations.SerializedName

data class LoginWithEmailRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("device_id") val deviceId: String,
    @SerializedName("device_type") val deviceType: String,
)