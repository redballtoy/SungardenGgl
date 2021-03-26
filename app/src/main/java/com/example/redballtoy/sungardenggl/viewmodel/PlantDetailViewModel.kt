package com.example.redballtoy.sungardenggl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redballtoy.sungardenggl.room.GardenPlantingRepository
import com.example.redballtoy.sungardenggl.room.PlantRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject


// viewmodel используемая в PlantDetailFragment

class PlantDetailViewModel @AssistedInject constructor(
        plantRepository: PlantRepository,
        private val gardenPlantingRepository: GardenPlantingRepository,
        @Assisted private val plantId: String
) : ViewModel() {

    val isPlanted = gardenPlantingRepository.isPlanted(plantId).asLiveData()
    val plant = plantRepository.getPlant(plantId)

    fun addPlantToGarden(){
        viewModelScope.{
            gardenPlantingRepository.createGardenPlanting(plantId)

        }
    }

}
