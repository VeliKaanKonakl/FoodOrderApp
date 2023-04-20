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
    // view olusturulan yer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        return binding.root
    }

    // view olustuktan sonra
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title = "Yemek Detay"

        val bundle:DetailFragmentArgs by navArgs()
        val foodFrom = bundle.food

        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${foodFrom.foodImage}")
            .override(500,500)
            .into(binding.detailImageName)
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
            if (pieceInt > 0){
                pieceInt = pieceInt - 1
            }
            binding.editTextPieceDetail.setText("${pieceInt}")
        }
    }

}