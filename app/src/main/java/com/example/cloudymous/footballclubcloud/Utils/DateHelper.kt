package com.example.cloudymous.footballclubcloud.Utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun formatMatchDate(date: Date) : String {
        return SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(date)
    }
}