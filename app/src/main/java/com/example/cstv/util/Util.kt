package com.example.cstv.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


fun formatDate(date: String?): String {
    try {
        val todayDate = Calendar.getInstance()

        val givenDate = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        sdf.timeZone = TimeZone.getDefault()
        givenDate.time = sdf.parse(date)

        val dateFormatted = StringBuilder()

        if (todayDate.get(Calendar.DAY_OF_YEAR) == givenDate.get(Calendar.DAY_OF_YEAR) &&
            todayDate.get(Calendar.YEAR) == givenDate.get(Calendar.YEAR)
        ) {
            dateFormatted.append("Hoje")
        } else {
            dateFormatted.append(givenDate.get(Calendar.DAY_OF_WEEK).formatWeek())
        }

        val hour = givenDate.get(Calendar.HOUR)
        val minute = givenDate.get(Calendar.MINUTE)
        val time = String.format("%02d:%02d", hour, minute)

        dateFormatted.append(", $time")
        return dateFormatted.toString()
    } catch (ex: Exception) {
        return ""
    }
}

fun Int.formatWeek() = when (this) {
    1 -> "Seg"
    2 -> "Ter"
    3 -> "Qua"
    4 -> "Qui"
    5 -> "Sex"
    6 -> "Sab"
    else -> "Dom"
}
