package com.konakli.foodorderapp_main.data.entity

import com.google.gson.annotations.SerializedName

data class CartFoodResponse(
    @SerializedName("sepet_yemekler") val cartFoods: List<CartFoodModel>?,
    val success: Int?
)