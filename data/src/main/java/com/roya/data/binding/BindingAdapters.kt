package com.roya.data.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
interface BindingAdapters {

    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?)

    @BindingAdapter("roundedImageUrl", "radius")
    fun ImageView.setRoundedImageUrl(url: String?, radius: Int)
}
