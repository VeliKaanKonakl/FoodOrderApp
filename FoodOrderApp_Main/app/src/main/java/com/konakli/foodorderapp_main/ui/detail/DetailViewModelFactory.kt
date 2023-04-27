package com.konakli.foodorderapp_main.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.konakli.foodorderapp_main.data.repos.FoodRepository


class DetailViewModelFactory(private val repository: FoodRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(DetailViewModel::class.java!!)) {
            DetailViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}