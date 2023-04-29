package com.konakli.foodorderapp_main.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, imageUrl: String) {
    Glide.with(imageView)
        .load("http://kasimadalan.pe.hu/yemekler/resimler/$imageUrl")
        .override(300, 300)
        .into(imageView)
}