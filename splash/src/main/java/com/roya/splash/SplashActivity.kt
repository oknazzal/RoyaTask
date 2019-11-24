package com.roya.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.roya.core.Activities
import com.roya.core.intentTo

/**
 * Project: Roya
 * Created: Nov 24, 2019
 *
 * @author Odai
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentTo(Activities.Main))

        finish()
    }

    override fun onBackPressed() {
        // No impl
    }
}
