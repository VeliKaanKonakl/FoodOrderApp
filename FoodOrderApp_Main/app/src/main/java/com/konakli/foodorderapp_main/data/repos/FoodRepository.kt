package com.konakli.foodorderapp_main.data.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.entity.CartFoodModel
import com.konakli.foodorderapp_main.data.entity.CartFoodResponse
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.entity.FoodResponse
import com.konakli.foodorderapp_main.data.retrofit.ApiUtils
import com.konakli.foodorderapp_main.data.retrofit.FoodsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {

    private val foodService: FoodsService = ApiUtils.getFoodServices()

    var crudResponse = MutableLiveData<CRUDResponse>()
        private set

    var allFoodList = MutableLiveData<List<FoodModel>>()
        private set

    var cartFoodList = MutableLiveData<List<CartFoodModel>>()
        private set

    fun getAllFoods() {
        foodService.getAllFoods().enqueue(object : Callback<FoodResponse> {
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                allFoodList.value = response.body()?.foods.orEmpty()
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                Log.e("hata", t.message.orEmpty())
            }
        })
    }

    fun insertFood(
        foodName: String,
        foodImageName: String,
        foodPrice: Int,
        foodOrderPiece: Int,
        userName: String
    ) {
        foodService.insertFood(foodName, foodImageName, foodPrice, foodOrderPiece, userName)
            .enqueue(object : Callback<CRUDResponse> {
                override fun onResponse(
                    call: Call<CRUDResponse>,
                    response: Response<CRUDResponse>
                ) {
                    crudResponse.value = response.body()
                }

                override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                    Log.e("hata", t.message.orEmpty())
                }
            })
    }

    fun getCartFoods() {
        foodService.getCartFoods(userName = "konakli").enqueue(object : Callback<CartFoodResponse> {
            override fun onResponse(
                call: Call<CartFoodResponse>,
                response: Response<CartFoodResponse>
            ) {
                cartFoodList.value = response.body()?.cartFoods?.groupBy { it.foodName }?.map {
                    CartFoodModel(
                        it.value[0].cartFoodId,
                        it.value[0].foodId,
                        it.key,
                        it.value[0].foodImage,
                        it.value[0].foodPrice,
                        it.value[0].userName,
                        it.value.size
                    )
                }
            }

            override fun onFailure(call: Call<CartFoodResponse>, t: Throwable) {
                Log.e("hata", t.message.orEmpty())
            }
        })
    }

    fun deleteCartFoods(cartFoodId: Int) {
        foodService.deleteFood(cartFoodId, userName = "konakli")
            .enqueue(object : Callback<CRUDResponse> {
                override fun onResponse(
                    call: Call<CRUDResponse>,
                    response: Response<CRUDResponse>
                ) {
                    if (response.body()?.success == 1) {
                        getCartFoods()
                    }
                }

                override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {
                    Log.e("hata", t.message.orEmpty())
                }
            })
    }
}
