package com.konakli.foodorderapp_main.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.CRUDResponse
import com.konakli.foodorderapp_main.data.entity.CartFoodResponse
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.repos.FoodRepository
import com.konakli.foodorderapp_main.data.retrofit.FoodsService

class CartViewModel() : ViewModel() {

    private val fdao = FoodRepository()
    val response: LiveData<CartFoodResponse>
        get() = fdao.cartFoodItems

    init {
        fdao.getCartFoods()
    }

}