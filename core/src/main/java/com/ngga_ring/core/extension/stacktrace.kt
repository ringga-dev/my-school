package com.ngga_ring.core.extension

import com.ngga_ring.core.BuildConfig

fun Throwable.debugPrintStackTrace() {
    if (BuildConfig.DEBUG) {
        this.printStackTrace()
    }
}