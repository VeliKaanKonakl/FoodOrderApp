package com.konakli.foodorderapp_main.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.databinding.CardDesignBinding
import com.konakli.foodorderapp_main.ui.home.HomeViewModel

class AdapterHome(var mContext:Context,var foodList:List<FoodModel>,var viewModel:HomeViewModel) :
    RecyclerView.Adapter<AdapterHome.CardViewFood>(){

    inner class CardViewFood(var binding: CardDesignBinding):RecyclerView.ViewHolder(binding.root) {
        val productImage = binding.foodCardImage
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewFood {
        val binding: CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design,parent,false)
        return CardViewFood(binding)
    }



    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: CardViewFood, position: Int) {
        val food = foodList.get(position)
        val t = holder.binding

        t.foodObject = food
        //t.yemekCardResim
        Glide.with(mContext)
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.foodImage}")
            .override(300,300)
            .into(holder.productImage)
    }
}