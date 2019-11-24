package com.roya.core.custom.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.R
import com.google.android.material.bottomappbar.BottomAppBar


/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class CustomBottomAppBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.bottomAppBarStyle
) : BottomAppBar(context, attrs, defStyleAttr) {

    private var onSlideDown: ((child: BottomAppBar?) -> Unit)? = null
    private var onSlideUp: ((child: BottomAppBar?) -> Unit)? = null
    private var behavior: Behavior? = null

    override fun getBehavior(): Behavior {
        if (behavior == null) {
            behavior = BottomAppBarBehavior()
        }
        return behavior!!
    }

    fun onSlideDown(listener: (BottomAppBar?) -> Unit) {
        onSlideDown = { listener(it) }
    }

    fun onSlideUp(listener: (BottomAppBar?) -> Unit) {
        onSlideUp = { listener(it) }
    }

    inner class BottomAppBarBehavior : Behavior() {

        override fun slideDown(child: BottomAppBar) {
            super.slideDown(child)
            onSlideDown?.invoke(child)
        }

        override fun slideUp(child: BottomAppBar) {
            super.slideUp(child)
            onSlideUp?.invoke(child)
        }
    }
}
