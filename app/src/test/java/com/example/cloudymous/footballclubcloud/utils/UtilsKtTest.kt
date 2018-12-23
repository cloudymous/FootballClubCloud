package com.example.cloudymous.footballclubcloud.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class UtilsKtTest {

    @Test
    fun formatDate() {

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val date = simpleDateFormat.parse("2018-11-26")
        val dateWithDay = SimpleDateFormat("EEEE, dd MMM yyyy")
        assertEquals("Senin, 26 Nov 2018", dateWithDay.format(date))
    }

    @Test
    fun formatTime() {

        val simpleDateFormat = SimpleDateFormat("HH:mm")
        simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
        val time = simpleDateFormat.parse("20:00:00+00:00")
        assertEquals("20:00", simpleDateFormat.format(time))

    }
}