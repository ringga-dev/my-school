package com.ngga_ring.myschool.extension

import android.app.Activity
import android.widget.Toast

fun Activity.toastSimple(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}