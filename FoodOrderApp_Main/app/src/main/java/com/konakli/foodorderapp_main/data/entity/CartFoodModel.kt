package com.konakli.foodorderapp_main.data.entity

import com.google.gson.annotations.SerializedName

data class CartFoodModel(
    @SerializedName("sepet_yemek_id") val cartFoodId : Int,
    @SerializedName("yemek_id") val foodId: Int,
    @SerializedName("yemek_adi") val foodName: String,
    @SerializedName("yemek_resim_adi") val foodImage: String,
    @SerializedName("yemek_fiyat") val foodPrice: Int,
    @SerializedName("kullanici_adi") val userName: String
) {
}