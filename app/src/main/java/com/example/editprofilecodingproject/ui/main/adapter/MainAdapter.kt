package com.example.editprofilecodingproject.ui.main.adapter

import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


object DataBindingAdapters {
    @BindingAdapter("bindImage")
    @JvmStatic
    fun bindImage(imageView: ImageView, imageUri: String?) {
        Log.i("IMAGE", imageUri.toString())
        Glide.with(imageView.context)
                .load(imageUri).apply(RequestOptions().circleCrop())
                .into(imageView)
    }

}
