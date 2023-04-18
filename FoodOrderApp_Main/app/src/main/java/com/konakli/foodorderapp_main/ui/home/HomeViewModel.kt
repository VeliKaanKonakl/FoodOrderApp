package com.konakli.foodorderapp_main.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.repos.FoodRepository

class HomeViewModel : ViewModel() {

    val foodRepo = FoodRepository()

    var foodsList: MutableLiveData<List<FoodModel>>

    init {
        foodLoading()
        foodsList = foodRepo.foodLoading()
    }

    fun foodLoading() {
        foodRepo.getAllFoods()
    }
}