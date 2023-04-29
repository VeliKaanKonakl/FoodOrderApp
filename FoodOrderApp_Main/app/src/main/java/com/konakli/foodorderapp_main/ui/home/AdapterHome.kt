package com.konakli.foodorderapp_main.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.databinding.CardDesignBinding

class AdapterHome(
    private var foodList: List<FoodModel>,
) :
    RecyclerView.Adapter<AdapterHome.CardViewFood>() {

    inner class CardViewFood(var binding: CardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: FoodModel) {

            with(binding) {

                foodObject = food

                foodCardView.setOnClickListener {
                    val to = HomeFragmentDirections.actionHomeFragmentToDetailFragment(food = food)
                    Navigation.findNavController(it).navigate(to)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CardViewFood(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.card_design, parent, false
        )
    )

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: CardViewFood, position: Int) =
        holder.bind(foodList[position])
}