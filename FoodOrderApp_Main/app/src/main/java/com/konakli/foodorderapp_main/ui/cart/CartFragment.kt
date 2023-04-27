package com.konakli.foodorderapp_main.ui.cart

import android.database.DatabaseUtils
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.databinding.FragmentCartBinding
import com.konakli.foodorderapp_main.databinding.FragmentDetailBinding
import retrofit2.Callback

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val viewModel : CartViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)
        binding = FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar2.title = "My Cart"
        binding.rvCart.layoutManager = LinearLayoutManager(requireContext())
        viewModel.response.observe(viewLifecycleOwner){
            binding.rvCart.adapter = AdapterCart(it.cartFoods)
        }
    }

}