package com.roya.news

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.paginate.Paginate
import com.roya.core.fragments.BaseFragment
import com.roya.data.network.Resource
import javax.inject.Inject


/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class NewsFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: NewsViewModel

    private val adapter by lazy { NewsAdapter(viewModel) }
    private var recyclerViewImages: RecyclerView? = null
    private var progressBarImages: ProgressBar? = null

    override val layoutId: Int = R.layout.fragment_news

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getNextPage()
    }

    private fun initViews() {
        recyclerViewImages = view?.findViewById(R.id.recycler_view_fragment_news_images)
        progressBarImages = view?.findViewById(R.id.progress_bar_fragment_news_images)

        recyclerViewImages?.adapter = adapter


        Paginate.with(recyclerViewImages, viewModel)
            .setLoadingTriggerThreshold(2)
            .addLoadingListItem(false)
            .build()
    }

    private fun getNextPage() {
        viewModel.newsLiveData.observe(this, this::handleResource)
    }

    private fun handleResource(resource: Resource<Unit>) {
        when (resource) {
            is Resource.Loading -> {
                handleLoadingResource(resource)
            }
            is Resource.Success -> {
                handleSuccessResource()
            }
            is Resource.Error -> {
                handleErrorResource(resource)
            }
        }
    }

    private fun handleLoadingResource(resource: Resource.Loading<Unit>) {
        if (resource.show) {
            progressBarImages?.visibility = View.VISIBLE
        } else {
            progressBarImages?.visibility = View.GONE
        }
    }

    private fun handleSuccessResource() {
        recyclerViewImages?.adapter?.notifyDataSetChanged()
    }

    private fun handleErrorResource(resource: Resource.Error<Unit>) {
        view?.let { view ->
            Snackbar.make(view, resource.error.message ?: "", Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.action_retry) { getNextPage() }
        }
    }
}
