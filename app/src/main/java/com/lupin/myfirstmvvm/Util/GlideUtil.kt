package com.lupin.myfirstmvvm.Util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


fun ImageView.loadFromURL(url:String){
    Glide.with(this)
        .load(url)
        .into(this)
}

fun ImageView.loadFromURLAndCircular(url:String){
    Glide.with(this)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}