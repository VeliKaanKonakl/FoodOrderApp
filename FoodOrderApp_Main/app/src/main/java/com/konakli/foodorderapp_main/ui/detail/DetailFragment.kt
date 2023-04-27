package com.konakli.foodorderapp_main.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.data.repos.FoodRepository
import com.konakli.foodorderapp_main.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel


    // view olusturulan yer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this,DetailViewModelFactory(FoodRepository())).get(DetailViewModel::class.java)
        return binding.root
    }

    // view olustuktan sonra
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title = "Yemek Detay"

        val bundle: DetailFragmentArgs by navArgs()
        val foodFrom = bundle.food

        Glide.with(requireContext())
            .load("http://kasimadalan.pe.hu/yemekler/resimler/${foodFrom.foodImage}")
            .override(500, 500)
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
            if (pieceInt > 0) {
                pieceInt = pieceInt - 1
            }
            binding.editTextPieceDetail.setText("${pieceInt}")
        }

        binding.addToCartDetail.setOnClickListener {
            postFood(foodFrom)
        }
        viewModel.response.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun postFood(foodFrom : FoodModel) {
        val foodName = binding.foodNameDetailView.text.toString()
        val foodImageName = binding.detailImageName.toString()
        val foodPrice = binding.foodPriceDetailView.text.toString()
        val foodOrderPiece = binding.editTextPieceDetail.text.toString()
        val userName = binding.editTextUserNameDetail.text.toString()

        viewModel.insert(
            foodFrom.foodName,
            foodFrom.foodImage,
            foodFrom.foodPrice,
            foodOrderPiece.toInt(),
            userName
        )
    }

}