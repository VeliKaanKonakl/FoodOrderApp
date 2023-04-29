package com.konakli.foodorderapp_main.ui.detail

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.konakli.foodorderapp_main.R
import com.konakli.foodorderapp_main.data.entity.FoodModel
import com.konakli.foodorderapp_main.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel: DetailViewModel by viewModels()

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            toolbar.title = "Yemek Detay"
            detailFragment = this@DetailFragment
            foodModel = args.food
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.response.observe(viewLifecycleOwner) {
            if (!viewModel.isShow) {
                Snackbar.make(requireView(), "${it.message}", Snackbar.LENGTH_LONG).apply {
                    val params = view.layoutParams as FrameLayout.LayoutParams
                    params.gravity = Gravity.TOP
                    view.layoutParams = params
                    show()
                }
                viewModel.isShow = true
            }
        }

        viewModel.piece.observe(viewLifecycleOwner) {
            binding.piece = it.toString()
        }
    }

    fun postFood(foodModel: FoodModel) {
        val foodOrderPiece = binding.editTextPieceDetail.text.toString()
        val userName = binding.editTextUserNameDetail.text.toString()

        viewModel.insertFood(
            foodModel.foodName.orEmpty(),
            foodModel.foodImage.orEmpty(),
            foodModel.foodPrice ?: 0,
            foodOrderPiece.toInt(),
            userName
        )
    }

    fun increasePiece() = viewModel.increasePiece()

    fun decreasePiece() = viewModel.decreasePiece()
}
