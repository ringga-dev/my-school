package com.ngga_ring.repository.repository.remote.network

import com.ngga_ring.repository.common.Constant.AUTH_TOKEN
import com.ngga_ring.repository.repository.local.AuthPrefs
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Interceptor to add auth token to requests
 */
class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header(AUTH_TOKEN, AuthPrefs.token?.tokenType + " " + AuthPrefs.token?.accessToken)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}