package com.konakli.foodorderapp_main.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.databinding.FragmentHomeBinding
import com.konakli.foodorderapp_main.ui.home.AdapterHome
import com.konakli.foodorderapp_main.ui.home.HomeViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarHome.title = "Yemek Siparis Uygulamasi"

        binding.rvFoods.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.foodsList.observe(viewLifecycleOwner) {
            val adapter = AdapterHome(it)
            binding.homeAdapter = adapter
        }
    }
}