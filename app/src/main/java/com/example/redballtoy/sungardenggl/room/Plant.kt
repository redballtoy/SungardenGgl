package com.example.redballtoy.sungardenggl.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
import java.util.Calendar.DAY_OF_YEAR

//анотация @Entity определяет таблицу с названием plants
@Entity(tableName = "plants")
data class Plant(
    //определяется первичный и имя связанного с ним столбца, если имя столбца не определено,
    //Room в качестве имени столбца будет использовать имя переменной
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl: String = ""
) {
    fun shouldBeWatered(since: Calendar, lastWateringDate: Calendar) =
        since > lastWateringDate.apply { add(DAY_OF_YEAR, wateringInterval) }

    override fun toString() = name
}
