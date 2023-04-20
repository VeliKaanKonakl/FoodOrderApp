package com.konakli.foodorderapp_main.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.entity.FoodResponse
import com.konakli.foodorderapp_main.data.retrofit.ApiUtils
import com.konakli.foodorderapp_main.databinding.CardDesignBinding
import com.konakli.foodorderapp_main.ui.detail.DetailFragment
import com.konakli.foodorderapp_main.ui.home.HomeViewModel

class AdapterHome(var foodList:List<FoodModel>) :
    RecyclerView.Adapter<AdapterHome.CardViewFood>(){

    inner class CardViewFood(var binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root) {

        fun bind(food : FoodModel){
             Glide.with(itemView)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.foodImage}")
            .override(300,300)
            .into(productImage)
            with(binding){
                foodObject = food
                foodCardView.setOnClickListener {
                    val to = HomeFragmentDirections.actionHomeFragmentToDetailFragment(food = food)
                    Navigation.findNavController(it).navigate(to)
                }
            }
        }

        val productImage = binding.foodCardImage
    }
    /*
    var allFoodList = MutableLiveData<List<FoodModel>>()
    init {
        allFoodList = MutableLiveData()
    }*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewFood {
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.card_design,parent,false)
        return CardViewFood(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardViewFood, position: Int) {
        val food = foodList.get(position)

        holder.bind(food)

    }
}