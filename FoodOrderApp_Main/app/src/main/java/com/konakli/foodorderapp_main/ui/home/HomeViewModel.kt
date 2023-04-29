package com.konakli.foodorderapp_main.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.repos.FoodRepository

class HomeViewModel : ViewModel() {

    private val foodRepository = FoodRepository()

    var foodsList = MutableLiveData<List<FoodModel>>()
        private set

    init {
        getAllFoods()
    }

    private fun getAllFoods() {
        foodRepository.getAllFoods()
        foodsList = foodRepository.allFoodList
    }
}