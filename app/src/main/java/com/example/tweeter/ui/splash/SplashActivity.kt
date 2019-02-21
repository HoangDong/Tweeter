package com.example.tweeter.ui.splash

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.example.tweeter.R
import com.example.tweeter.utils.ActivityUtils


class SplashActivity : AppCompatActivity() {
    companion object {
        const val TIME_WAIT=2000L
    }

    private val mWaitHandler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mWaitHandler.postDelayed({
            ActivityUtils.startMainActivity(this)
        }, TIME_WAIT)
    }

    override fun onDestroy() {
        super.onDestroy()
        mWaitHandler.removeCallbacksAndMessages(null)
    }
}
