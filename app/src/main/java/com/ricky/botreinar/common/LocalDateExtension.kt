package com.ricky.botreinar.common

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Locale

fun LocalDate.convertToString():String{
    return SimpleDateFormat(
        "dd/MM/yyyy",
        Locale.getDefault()
    ).format(this)
}