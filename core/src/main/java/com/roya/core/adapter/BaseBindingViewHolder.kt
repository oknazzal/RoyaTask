package com.roya.core.adapter

import androidx.databinding.ViewDataBinding

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
abstract class BaseBindingViewHolder(viewDataBinding: ViewDataBinding) : BaseViewHolder(viewDataBinding.root) {

    var viewDataBinding: ViewDataBinding? = viewDataBinding

    @Suppress("UNCHECKED_CAST")
    inline fun <T : ViewDataBinding> bind(binding: T.() -> Unit) {
        binding(viewDataBinding as T)
        viewDataBinding?.executePendingBindings()
    }
}
