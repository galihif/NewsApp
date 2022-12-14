package com.example.newsapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

object AppUtils {
    fun ImageView.loadImage(imageSource : String) {
        Glide.with(context)
            .load(imageSource)
            .into(this)
    }

}