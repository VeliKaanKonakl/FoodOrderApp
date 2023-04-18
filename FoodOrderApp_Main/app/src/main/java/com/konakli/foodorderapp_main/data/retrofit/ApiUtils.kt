package com.konakli.foodorderapp_main.data.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"
        fun getFoodServices() = RetrofitClient.getClient(baseUrl = BASE_URL).create(FoodsService::class.java)
    }
}