package com.konakli.foodorderapp_main.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        binding.toolbar.title = "Yemek Detay"

        val bundle:DetailFragmentArgs by navArgs()
        val foodFrom = bundle.food


        binding.foodNameDetailView.setText(foodFrom.foodName)
        binding.foodPriceDetailView.setText("${foodFrom.foodPrice} ₺")

        binding.plusDetailButton.setOnClickListener {
            val piece = binding.editTextPieceDetail.text.toString()
            var pieceInt = piece.toInt()
            pieceInt = pieceInt + 1
            binding.editTextPieceDetail.setText("${pieceInt}")

        }

        binding.decreaseDetailButton.setOnClickListener {
            val piece = binding.editTextPieceDetail.text.toString()
            var pieceInt = piece.toInt()
            pieceInt = pieceInt - 1
            binding.editTextPieceDetail.setText("${pieceInt}")
        }

        return binding.root
    }
}