package com.example.redballtoy.sungardenggl.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlantDao {
    //результат запроса возвращает объект класса LiveData
    @Query("SELECT * FROM plants ORDER BY name")
    fun getPlants(): LiveData<List<Plant>>

    @Query("SELECT * from plants where id=:plantId")
    fun getPlantById(plantId: String): LiveData<Plant>

    @Query("SELECT * from plants where name=:plantName")
    fun getPlantByName(plantName: String): LiveData<Plant>

    //аннотация вставки не требует написания SQL запроса, он будет сгенерирован автоматически
    //если при вставке возникнут конфликты то старые данные будут заменены на новые
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Plant>)
}