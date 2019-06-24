package com.nastynick.billdivider.presentation.util

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormat @Inject constructor() {

    private val timeDateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    fun formatWithTime(date: Date): String {
        return timeDateFormat.format(date)
    }

    fun format(date: Date): String {
        return dateFormat.format(date)
    }
}