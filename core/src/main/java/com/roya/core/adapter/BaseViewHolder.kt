package com.roya.core.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

    abstract fun bind(position: Int)
}
