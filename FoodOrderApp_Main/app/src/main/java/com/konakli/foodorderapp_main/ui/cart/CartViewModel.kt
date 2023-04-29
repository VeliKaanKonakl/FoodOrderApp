package com.konakli.foodorderapp_main.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.konakli.foodorderapp_main.data.entity.CartFoodModel
import com.konakli.foodorderapp_main.data.repos.FoodRepository

class CartViewModel : ViewModel() {

    private val foodRepository = FoodRepository()

    var cartFoodList = MutableLiveData<List<CartFoodModel>>()
        private set

    init {
        cartFoodList = foodRepository.cartFoodList
    }

    fun delete(cartFoodId: Int) {
        foodRepository.deleteCartFoods(cartFoodId)
        if (cartFoodList.value?.size == 1) cartFoodList.value = emptyList()
    }

    fun getCartFoods() {
        foodRepository.getCartFoods()
    }
}