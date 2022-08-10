package com.ngga_ring.repository.common

import java.util.*

object Helper {
    fun getLocale(): String {
        var locale = Locale.getDefault().language
        locale = if (locale == "in") "id" else "en"
        return locale
    }
}