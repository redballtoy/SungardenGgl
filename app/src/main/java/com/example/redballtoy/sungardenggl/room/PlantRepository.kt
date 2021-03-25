package com.example.redballtoy.sungardenggl.room

import javax.inject.Inject
import javax.inject.Singleton


/*
* Модуль репозитория для обработки операций с данными.
* Сбор из потоков Flows в PlantDao в безопасном для основного потока режиме
* Roon поддерживает корутины и перемещает их выполнение вне основного потока
* Служит прослойкой между Livedata и источником данных который может быть любым
*/

@Singleton
class PlantRepository @Inject constructor(private val plantDao: PlantDao) {

    fun getPlants() = plantDao.getPlants()

    fun getPlant(plantId: String) = plantDao.getPlantById(plantId)

    fun getPlantWithGrowZoneNumber(growZoneNumber: Int) =
        plantDao.getPlantsWithGrowZoneNumber(growZoneNumber)

}