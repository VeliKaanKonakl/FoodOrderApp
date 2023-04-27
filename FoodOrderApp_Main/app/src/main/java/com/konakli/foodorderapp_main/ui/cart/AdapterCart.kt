package com.konakli.foodorderapp_main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.data.entity.CartFoodModel
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.databinding.CartCardDesignBinding
import com.konakli.foodorderapp_main.ui.home.AdapterHome
import com.konakli.foodorderapp_main.ui.home.HomeFragmentDirections

class AdapterCart(var cartFoodList: List<CartFoodModel>) :
    RecyclerView.Adapter<AdapterCart.CartCardViewFood>() {

        inner class CartCardViewFood(var binding: CartCardDesignBinding):RecyclerView.ViewHolder(binding.root) {
            fun bind(food: CartFoodModel) {
                Glide.with(itemView)
                    .load("http://kasimadalan.pe.hu/yemekler/resimler/${food.foodImage}")
                    .override(300, 300)
                    .into(productImage)
                with(binding) {
                    cartFoodObject = food
                    deleteImage.setOnClickListener{

                    }
                }
            }

            val productImage = binding.foodCartImageName
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartCardViewFood {
        return CartCardViewFood(CartCardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return cartFoodList.size
    }

    override fun onBindViewHolder(holder: CartCardViewFood, position: Int) {
        holder.bind(cartFoodList.get(position))
    }

}