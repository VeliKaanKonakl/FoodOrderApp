package com.konakli.foodorderapp_main.data.retrofit

object ApiUtils {
    private const val BASE_URL = "http://kasimadalan.pe.hu/"
    fun getFoodServices(): FoodsService =
        RetrofitClient.getClient(baseUrl = BASE_URL).create(FoodsService::class.java)
}