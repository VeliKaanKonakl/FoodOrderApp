package com.konakli.foodorderapp_main.data.repos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.entity.CartFoodResponse
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.entity.FoodResponse
import com.konakli.foodorderapp_main.data.retrofit.ApiUtils
import com.konakli.foodorderapp_main.data.retrofit.FoodsService
import com.konakli.foodorderapp_main.databinding.FragmentDetailBinding
import com.konakli.foodorderapp_main.ui.detail.DetailFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRepository {

    private val foodService: FoodsService = ApiUtils.getFoodServices()

    var allFoodList = MutableLiveData<List<FoodModel>>()
    var fdao: FoodsService

    private val _response = MutableLiveData<CRUDResponse>()
    val response: LiveData<CRUDResponse>
        get() = _response

    private val _cartFoodItems = MutableLiveData<CartFoodResponse>()
    val cartFoodItems : LiveData<CartFoodResponse>
        get() = _cartFoodItems

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

    fun insertFood(foodName: String,
                   foodImageName: String,
                   foodPrice : Int,
                   foodOrderPiece : Int,
                   userName : String
                   ) {

        fdao.insertFood(foodName,foodImageName,foodPrice,foodOrderPiece,userName).enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {
                _response.value = response.body()
            }
            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }
        })
    }

    fun getCartFoods(){
        fdao.getCartFoods(userName = "konakli").enqueue(object : Callback<CartFoodResponse>{
            override fun onResponse(
                call: Call<CartFoodResponse>,
                response: Response<CartFoodResponse>
            ) {
                _cartFoodItems.value = response.body()
            }
            override fun onFailure(call: Call<CartFoodResponse>, t: Throwable) {
            }
        })
    }

    fun deleteCartFoods(){
        fdao.deleteFood(1/*##*/, userName = "konakli").enqueue(object : Callback<CRUDResponse>{
            override fun onResponse(call: Call<CRUDResponse>, response: Response<CRUDResponse>) {

            }
            override fun onFailure(call: Call<CRUDResponse>, t: Throwable) {

            }

        })
    }

}


