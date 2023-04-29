package com.konakli.foodorderapp_main.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.CartFoodModel
import com.konakli.foodorderapp_main.databinding.CartCardDesignBinding

class AdapterCart(
    private val cartFoodList: List<CartFoodModel>,
    private val onDeleteClick: (Int) -> Unit
) : RecyclerView.Adapter<AdapterCart.CartCardViewFood>() {

    inner class CartCardViewFood(private val binding: CartCardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: CartFoodModel) {

            with(binding) {

                cartFoodObject = food

                deleteImage.setOnClickListener {
                    food.cartFoodId?.let { id ->
                        onDeleteClick(id)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CartCardViewFood(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.cart_card_design, parent, false
        )
    )

    override fun getItemCount() = cartFoodList.size

    override fun onBindViewHolder(holder: CartCardViewFood, position: Int) =
        holder.bind(cartFoodList[position])
}
