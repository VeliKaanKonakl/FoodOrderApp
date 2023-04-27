package com.konakli.foodorderapp_main.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.repos.FoodRepository
import com.konakli.foodorderapp_main.data.retrofit.FoodsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.CryptoPrimitive

class DetailViewModel(private val service: FoodRepository) : ViewModel() {
    val response: LiveData<CRUDResponse>get() = service.response

    fun insert(
        foodName: String,
        foodImageName: String,
        foodPrice: Int,
        foodOrderPiece: Int,
        userName: String
    ) {
        service.insertFood(foodName,foodImageName,foodPrice,foodOrderPiece,userName)
    }
}