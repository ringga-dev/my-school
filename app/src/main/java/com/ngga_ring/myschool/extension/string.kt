package com.ngga_ring.myschool.extension

fun String.getInitials(maxChar: Int = Int.MAX_VALUE): String {
    if (this.isEmpty()) return ""
    val initials = StringBuilder()
    val splitWords = this.split(" ")

    for (s in splitWords) {
        if (initials.length < maxChar) {
            if (s.isNotEmpty()) {
                initials.append(s[0])
            }
        } else {
            break
        }
    }
    return initials.toString()
}

fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")