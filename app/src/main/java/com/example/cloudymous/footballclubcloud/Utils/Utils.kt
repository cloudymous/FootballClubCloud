package com.example.cloudymous.footballclubcloud.Utils

import android.view.View
import java.text.SimpleDateFormat

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun formatDate(strDate: String?): String {
    val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
    val date = simpleDateFormat.parse(strDate)
    val dateWithDay = SimpleDateFormat("EEEE, dd MMM yyy")
    return dateWithDay.format(date)
}