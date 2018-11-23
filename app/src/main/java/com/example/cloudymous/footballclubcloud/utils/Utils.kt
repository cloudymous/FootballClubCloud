package com.example.cloudymous.footballclubcloud.utils

import android.view.View
import java.text.SimpleDateFormat
import java.util.*

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

fun formatDate(strDate: String?): String {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    val date = simpleDateFormat.parse(strDate)
    val dateWithDay = SimpleDateFormat("EEEE, dd MMM yyyy")
    return dateWithDay.format(date)
}

fun formatTime(strTime: String?): String {
    val simpleDateFormat = SimpleDateFormat("HH:mm")
    simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
    val time = simpleDateFormat.parse(strTime)
    return simpleDateFormat.format(time)
}