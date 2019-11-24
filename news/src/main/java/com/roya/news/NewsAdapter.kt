package com.roya.news

import android.view.ViewGroup
import com.roya.core.adapter.BaseAdapter
import com.roya.core.adapter.BaseBindingViewHolder
import com.roya.news.databinding.RowNewsBinding

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class NewsAdapter(private val viewModel: NewsViewModel) : BaseAdapter<NewsAdapter.ViewHolder>() {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowNewsBinding.inflate(inflater!!, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = viewModel.getNewsCount()

    inner class ViewHolder(binding: RowNewsBinding) : BaseBindingViewHolder(binding) {

        override fun bind(position: Int) {
            bind<RowNewsBinding> { news = viewModel.getNewsBy(position) }
        }
    }
}
