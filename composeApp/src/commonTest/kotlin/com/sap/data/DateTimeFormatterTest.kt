package com.sap.data

import kotlin.test.Test
import kotlin.test.assertEquals

class DateTimeFormatterTest {
    @Test
    fun `test toFormattedDateTime with valid epoch timestamp`() {
        val epochTime = 1739654019723L // 15-02-2024 22:13 UTC
        val epochTime2 = 1739653858258L // 15-02-2025 22:10 UTC

        val expected = "2025-02-15 22:13"
        val expected2 = "2025-02-15 22:10"

        val result = epochTime.toFormattedDateTime()
        val result2 = epochTime2.toFormattedDateTime()

        assertEquals(expected, result)
        assertEquals(expected2, result2)
    }

}