@file:JvmName("Dimensions")

package com.roya.data

import android.content.Context
import android.util.TypedValue

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
fun Int.dpToPx(context: Context?): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context?.resources?.displayMetrics)
}
