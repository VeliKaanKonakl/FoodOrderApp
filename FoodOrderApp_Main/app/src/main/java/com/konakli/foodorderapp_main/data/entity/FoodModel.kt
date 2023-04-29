package com.konakli.foodorderapp_main.data.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodModel(
    @SerializedName("yemek_id") val foodId: Int?,
    @SerializedName("yemek_adi") val foodName: String?,
    @SerializedName("yemek_resim_adi") val foodImage: String?,
    @SerializedName("yemek_fiyat") val foodPrice: Int?
) : Parcelable