package com.ngga_ring.repository.repository.local

import com.chibatching.kotpref.KotprefModel
import com.chibatching.kotpref.enumpref.nullableEnumValuePref
import com.chibatching.kotpref.gsonpref.gsonNullablePref
import com.ngga_ring.core.model.login.LoginMethod
import com.ngga_ring.repository.repository.remote.request.LoginWithEmailRequest
import com.ngga_ring.repository.repository.remote.request.LoginWithStaffCodeRequest

object LoginPrefs : KotprefModel() {
    var loginMethod by nullableEnumValuePref<LoginMethod>()
    var rememberedLoginWithEmail by gsonNullablePref<LoginWithEmailRequest>()
    var rememberedLoginWithStaff by gsonNullablePref<LoginWithStaffCodeRequest>()
}