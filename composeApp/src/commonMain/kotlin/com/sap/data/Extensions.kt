package com.sap.data

import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

internal fun Long.toFormattedDateTime(): String {
    val instant = Instant.fromEpochMilliseconds(this)
    val timeZone = TimeZone.of("Europe/Berlin")
    val localDateTime = instant.toLocalDateTime(timeZone)

    val day = localDateTime.dayOfMonth
    val month = localDateTime.monthNumber
    val year = localDateTime.year
    val hour = localDateTime.hour
    val minute = localDateTime.minute

    return "${year.toString().padStart(4, '0')}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')} ${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"
}
