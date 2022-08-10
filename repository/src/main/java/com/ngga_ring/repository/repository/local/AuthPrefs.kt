package com.ngga_ring.repository.repository.local

import com.chibatching.kotpref.KotprefModel
import com.google.gson.Gson
import com.ngga_ring.repository.model.auth.Store
import com.ngga_ring.repository.model.auth.Token
import com.ngga_ring.repository.model.auth.User

object AuthPrefs : KotprefModel() {
    private var tokenJson by stringPref()
    var token: Token?
        set(value) {
            val json = Gson().toJson(value)
            tokenJson = json
        }
        get() {
            return Gson().fromJson(tokenJson, Token::class.java)
        }

    private var userJson by stringPref()
    var user: User?
        set(value) {
            val json = Gson().toJson(value)
            userJson = json
        }
        get() {
            return Gson().fromJson(userJson, User::class.java)
        }

    private var storeJson by stringPref()
    var store: Store?
        set(value) {
            val json = Gson().toJson(value)
            storeJson = json
        }
        get() {
            return Gson().fromJson(storeJson, Store::class.java)
        }

    fun logout() {
        token = null
        user = null
        store = null
    }
}