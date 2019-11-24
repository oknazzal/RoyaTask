package com.roya.main

import android.os.Bundle
import com.roya.core.activities.BaseToolbarActivity
import javax.inject.Inject

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class MainActivity : BaseToolbarActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun hasBackButton(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
