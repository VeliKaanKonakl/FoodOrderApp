package com.konakli.foodorderapp_main.data.retrofit

import androidx.lifecycle.LiveData
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.entity.CartFoodModel
import com.konakli.foodorderapp_main.data.entity.CartFoodResponse
import com.konakli.foodorderapp_main.data.entity.FoodResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsService {
    //http://kasimadalan.pe.hu/
    @GET("yemekler/tumYemekleriGetir.php")
    fun getAllFoods(): Call<FoodResponse>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun insertFood(
        @Field("yemek_adi") foodName : String,
        @Field("yemek_resim_adi") foodImageName : String,
        @Field("yemek_fiyat") foodPrice : Int,
        @Field("yemek_siparis_adet") foodOrderPiece : Int,
        @Field("kullanici_adi") userName : String,
    ) : Call<CRUDResponse>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun getCartFoods(
        @Field("kullanici_adi") userName : String
    ): Call<CartFoodResponse>

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteFood(
        @Field("sepet_yemek_id") cartFoodId : Int,
        @Field("kullanici_adi") userName : String
    ) : Call<CRUDResponse>

}