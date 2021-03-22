package com.example.redballtoy.sungardenggl.room

import androidx.room.TypeConverters
import java.util.*

class Converters {
    @TypeConverters
    fun calendarToDatestamp(calendar: Calendar):Long = calendar.timeInMillis

    @TypeConverters
    fun datestampToCalendar(value: Long):Calendar =
        Calendar.getInstance().apply{timeInMillis=value}
}