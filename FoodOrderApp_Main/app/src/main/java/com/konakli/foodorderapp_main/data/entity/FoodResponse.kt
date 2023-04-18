package com.konakli.foodorderapp_main.data.entity

import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("yemekler") val foods: List<FoodModel>,
    val success: Int
)