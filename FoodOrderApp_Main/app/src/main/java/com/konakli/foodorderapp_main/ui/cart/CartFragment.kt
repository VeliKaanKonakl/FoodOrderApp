package com.konakli.foodorderapp_main.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    private val viewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCartFoods()

        binding.toolbar.title = "My Cart"

        viewModel.cartFoodList.observe(viewLifecycleOwner) {
            binding.cartAdapter = AdapterCart(it, onDeleteClick = ::onDeleteClick)
        }
    }

    private fun onDeleteClick(foodCartId: Int) = viewModel.delete(foodCartId)

}
