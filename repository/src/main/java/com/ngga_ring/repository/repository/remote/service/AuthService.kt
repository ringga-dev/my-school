package com.ngga_ring.repository.repository.remote.service

import com.ngga_ring.repository.repository.remote.request.LoginWithEmailRequest
import com.ngga_ring.repository.repository.remote.request.LoginWithStaffCodeRequest
import com.ngga_ring.repository.repository.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {
    @POST("api/pos/v4/{locale}/account/login")
    suspend fun loginByEmail(
        @Path("locale") locale: String,
        @Body loginRequest: LoginWithEmailRequest,
    ): LoginResponse

    @POST("api/pos/v4/{locale}/account/login")
    suspend fun loginByStaffCode(
        @Path("locale") locale: String,
        @Body loginRequest: LoginWithStaffCodeRequest,
    ): LoginResponse
}