package com.konakli.foodorderapp_main.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.repos.FoodRepository

class DetailViewModel : ViewModel() {

    private val foodRepository = FoodRepository()

    var response = MutableLiveData<CRUDResponse>()
        private set

    var piece = MutableLiveData(1)
        private set

    var isShow = false

    init {
        response = foodRepository.crudResponse
    }

    fun insertFood(
        foodName: String,
        foodImageName: String,
        foodPrice: Int,
        foodOrderPiece: Int,
        userName: String
    ) {
        isShow = false
        foodRepository.insertFood(foodName, foodImageName, foodPrice, foodOrderPiece, userName)
    }

    fun increasePiece() {
        piece.value = piece.value?.plus(1)
    }

    fun decreasePiece() {
        if (piece.value != 0) piece.value = piece.value?.minus(1)
    }
}
