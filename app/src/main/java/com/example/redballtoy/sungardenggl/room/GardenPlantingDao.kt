package com.example.redballtoy.sungardenggl.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//DAO для доступа к классу GardenPlanting

@Dao
interface GardenPlantingDao {
    @Query("SELECT * FROM garden_plantings")
    fun getAllGardenPlanting(): Flow<List<GardenPlanting>>

    @Query("SELECT EXISTS(SELECT 1 FROM garden_plantings WHERE plant_id=:plantId LIMIT 1)")
    fun isPlanted(plantId: String): Flow<Boolean>

    @Transaction
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    fun getPlandedGardes(): Flow<List<PlantAndGardenPlantings>>

    @Insert
    suspend fun insertGardenPlanting(gardenPlanting: GardenPlanting): Long

    @Delete
    suspend fun deleteGardenPlanting(gardenPlanting: GardenPlanting)
}