package com.ngga_ring.repository.repository

import com.ngga_ring.core.extension.debugPrintStackTrace
import com.ngga_ring.core.model.login.LoginMethod
import com.ngga_ring.repository.common.Helper
import com.ngga_ring.repository.repository.local.AppDatabase
import com.ngga_ring.repository.repository.local.AuthPrefs
import com.ngga_ring.repository.repository.local.LoginPrefs
import com.ngga_ring.repository.repository.remote.network.Resource
import com.ngga_ring.repository.repository.remote.request.LoginWithEmailRequest
import com.ngga_ring.repository.repository.remote.request.LoginWithStaffCodeRequest
import com.ngga_ring.repository.repository.remote.response.LoginResponse
import com.ngga_ring.repository.repository.remote.service.AuthService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepository(
    private val authService: AuthService,
    private val authPrefs: AuthPrefs,
    private val loginPrefs: LoginPrefs,
    private val db: AppDatabase,
) {

    fun loginWithEmail(request: LoginWithEmailRequest, rememberMe: Boolean): Flow<Resource<LoginResponse>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = authService.loginByEmail(Helper.getLocale(), request)
                if (!response.error.isNullOrEmpty()) {
                    emit(Resource.Error(response.error!!))
                } else {
                    authPrefs.token = response.token
                    authPrefs.user = response.user

                    db.storeDao().clear()
                    db.storeDao().insert(response.stores!!)

                    if (rememberMe) {
                        loginPrefs.loginMethod = LoginMethod.Email
                        loginPrefs.rememberedLoginWithEmail = request
                    } else {
                        loginPrefs.loginMethod = null
                        loginPrefs.rememberedLoginWithStaff = null
                        loginPrefs.rememberedLoginWithEmail = null
                    }

                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                e.debugPrintStackTrace()
                emit(Resource.Error())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun loginWithStaffCode(request: LoginWithStaffCodeRequest, rememberMe: Boolean): Flow<Resource<LoginResponse>> {
        return flow {
            emit(Resource.Loading)
            try {
                val response = authService.loginByStaffCode(Helper.getLocale(), request)
                if (!response.error.isNullOrEmpty()) {
                    emit(Resource.Error(response.error!!))
                } else {
                    authPrefs.token = response.token
                    authPrefs.user = response.user

                    db.storeDao().clear()
                    db.storeDao().insert(response.stores!!)

                    if (rememberMe) {
                        loginPrefs.loginMethod = LoginMethod.StaffCode
                        loginPrefs.rememberedLoginWithStaff = request
                    } else {
                        loginPrefs.loginMethod = null
                        loginPrefs.rememberedLoginWithStaff = null
                        loginPrefs.rememberedLoginWithEmail = null
                    }

                    emit(Resource.Success(response))
                }
            } catch (e: Exception) {
                e.debugPrintStackTrace()
                emit(Resource.Error())
            }
        }.flowOn(Dispatchers.IO)
    }

    fun isLoggedIn() = authPrefs.token?.accessToken != null
    fun isStoreSelected() = authPrefs.store != null

    fun isRememberMe() = getRememberedLoginMethod() != null
    fun getRememberedLoginMethod() = loginPrefs.loginMethod
    fun getRememberedLoginWithEmail() = loginPrefs.rememberedLoginWithEmail
    fun getRememberedLoginWithStaffCode() = loginPrefs.rememberedLoginWithStaff
    fun getUserName() = authPrefs.user?.name

    fun logout() {
        authPrefs.clear()
        db.storeDao().clear()
        db.productDao().clear()
    }

}