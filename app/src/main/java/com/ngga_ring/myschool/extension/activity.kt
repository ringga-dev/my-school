package com.ngga_ring.myschool.extension

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import java.util.*

fun Activity.getDeviceId(): String {
    var deviceId: String? = ""
    try {
        deviceId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
        } else {
            val mTelephony = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (this.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    return "OLSR"
                }
            }
            assert(mTelephony != null)
            if (mTelephony.deviceId != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mTelephony.imei
                } else {
                    mTelephony.deviceId
                }
            } else {
                Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
            }
        }
    } catch (ex: java.lang.Exception) {
        //do nothing
    }
    return if (deviceId == null || deviceId.length < 4) "OLSR" else deviceId.uppercase(Locale.getDefault())
}

fun Activity.setStatusBarBackgroudColor(color: Int) {
    val window: Window = window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = ContextCompat.getColor(this, color)
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.isPortrait(): Boolean =
    resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT