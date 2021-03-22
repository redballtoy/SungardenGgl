package com.example.redballtoy.sungardenggl.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class Plant(
    @PrimaryKey @ColumnInfo(name = "id")
    val plantId: String,
    val plantName: String,
    val description: String,
    val wateringInterval: Int = 7,
    val imageUrl: String = ""
)
