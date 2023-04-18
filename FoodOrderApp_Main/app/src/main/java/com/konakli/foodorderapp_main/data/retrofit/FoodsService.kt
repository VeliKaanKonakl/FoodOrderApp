package com.konakli.foodorderapp_main.data.retrofit

import com.konakli.foodorderapp_main.data.entity.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface FoodsService {
    //http://kasimadalan.pe.hu/
    @GET("yemekler/tumYemekleriGetir.php")
    fun getAllFoods(): Call<FoodResponse>
}