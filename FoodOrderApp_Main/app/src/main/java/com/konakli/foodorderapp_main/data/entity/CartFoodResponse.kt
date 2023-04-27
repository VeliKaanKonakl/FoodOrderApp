package com.konakli.foodorderapp_main.data.entity

import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName

class CartFoodResponse(
    @SerializedName("sepet_yemekler") val cartFoods : List<CartFoodModel>,
    val success: Int
)