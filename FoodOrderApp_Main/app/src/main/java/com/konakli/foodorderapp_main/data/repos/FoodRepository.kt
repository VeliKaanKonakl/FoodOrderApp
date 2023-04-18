package com.konakli.foodorderapp_main.data.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.entity.FoodResponse
import com.konakli.foodorderapp_main.data.retrofit.ApiUtils
import com.konakli.foodorderapp_main.data.retrofit.FoodsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {

    private val foodService: FoodsService = ApiUtils.getFoodServices()

    var allFoodList = MutableLiveData<List<FoodModel>>()
    var fdao: FoodsService

    init {
        fdao = ApiUtils.getFoodServices()
        allFoodList = MutableLiveData()
    }

    fun foodLoading(): MutableLiveData<List<FoodModel>> {
        return allFoodList
    }

    fun getAllFoods() {
        foodService.getAllFoods().enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {

                val list = response.body()!!.foods
                allFoodList.value = list
                /* response.body()?.foods?.let {
                        allFoodList.value = it
                    } */
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                Log.e("hata", t.message.orEmpty())
            }

        })
    }
}