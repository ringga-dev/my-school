package com.ngga_ring.myschool.extension

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.*

/**
 * Format integer to currency
 * (Int) 5000 -> (String) Rp 5.000
 */
fun Int.toCurrency(withSymbol: Boolean = true, currencySymbol: String = "Rp"): String {
    val symbolConfig = if (currencySymbol == "Rp") {
        val decFormat = DecimalFormatSymbols.getInstance()
        decFormat.groupingSeparator = '.'
        decFormat.decimalSeparator = ','
        decFormat
    } else {
        DecimalFormatSymbols.getInstance(Locale.US)
    }

    symbolConfig.currencySymbol = ""

    return if (withSymbol) {
        val formatter = NumberFormat.getCurrencyInstance() as DecimalFormat
        formatter.decimalFormatSymbols = symbolConfig
        formatter.maximumFractionDigits = 0
        "$currencySymbol ${formatter.format(this)}"
    } else {
        val formatter = NumberFormat.getInstance() as DecimalFormat
        formatter.decimalFormatSymbols = symbolConfig
        formatter.maximumFractionDigits = 0
        formatter.format(this)
    }
}

/**
 * Format integer to currency
 * (Int) 5000.75 -> (String) Rp 5.000,75
 */
fun Double.toCurrency(withSymbol: Boolean = true, currencySymbol: String = "Rp"): String {
    val symbolConfig = if (currencySymbol == "Rp") {
        val decFormat = DecimalFormatSymbols.getInstance()
        decFormat.groupingSeparator = '.'
        decFormat.decimalSeparator = ','
        decFormat
    } else {
        DecimalFormatSymbols.getInstance(Locale.US)
    }

    symbolConfig.currencySymbol = ""

    return if (withSymbol) {
        val formatter = NumberFormat.getCurrencyInstance() as DecimalFormat
        formatter.decimalFormatSymbols = symbolConfig
        "$currencySymbol ${formatter.format(this)}"
    } else {
        val formatter = NumberFormat.getInstance() as DecimalFormat
        formatter.decimalFormatSymbols = symbolConfig
        formatter.format(this)
    }
}

/**
 * Parse formatter currency to Int
 * (String) Rp 5.000,52 -> (Double) 5000.52
 */
fun String.fromCurrency(currencySymbol: String = "Rp"): Double {
    val clean = if (currencySymbol.lowercase() == "rp") {
        this.replace(Regex("[^0-9,]"), "")
            .replace(",", ".")
    } else {
        this.replace(Regex("[^0-9.]"), "")
    }
    return clean.toDouble()
}