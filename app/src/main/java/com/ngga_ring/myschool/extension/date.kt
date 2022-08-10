package com.ngga_ring.myschool.extension

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat


const val defaultDateFormat = "yyyy-MM-dd kk:mm:ss"
const val defaultUTCDateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

@SuppressLint("SimpleDateFormat")
fun String.convertDate(
    oldFormat: String,
    newFormat: String = defaultDateFormat
): String {
    try {
        if (this.isEmpty()) return "2022-08-08 12:00:00"
        val dateFormat = SimpleDateFormat(oldFormat)
        val confert = dateFormat.parse(this)
        dateFormat.applyPattern(newFormat)
        return dateFormat.format(confert ?: "")
    } catch (e: Exception) {
        return "2022-08-08 12:00:00"
    }
}

@SuppressLint("SimpleDateFormat")
fun String.convertDayTime(time: Boolean = true): String {
    val date = this

    var tanggal = ""
    var hari = ""

    val formatTgl = "dd MMM yyyy${if (time) " kk:mm" else ""}"
    val formatHari = "EEEE"
    val formatLama = defaultDateFormat

    val dateFormat = SimpleDateFormat(formatLama)
    val dateFormat2 = SimpleDateFormat(formatLama)
    try {
        val dd = dateFormat.parse(date)
        dateFormat.applyPattern(formatTgl)
        tanggal = dateFormat.format(dd!!)

        val mHari = dateFormat2.parse(date)
        dateFormat2.applyPattern(formatHari)
        hari = dateFormat2.format(mHari!!)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    when (hari) {
        "Sunday" -> hari = "Minggu"
        "Monday" -> hari = "Senin"
        "Tuesday" -> hari = "Selasa"
        "Wednesday" -> hari = "Rabu"
        "Thursday" -> hari = "Kamis"
        "Friday" -> hari = "Jumat"
        "Saturday" -> hari = "Sabtu"
    }

    return "$hari, $tanggal${if (time) " WIB" else ""}"
}