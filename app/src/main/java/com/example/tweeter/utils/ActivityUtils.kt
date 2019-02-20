package com.example.tweeter.utils

import android.app.Activity
import android.content.Intent
import com.example.tweeter.ui.main.MainActivity

object ActivityUtils {

    fun startMainActivity(activity: Activity) {
        val intent=Intent(activity,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        activity.startActivity(intent)
        activity.overridePendingTransition(0,0)
    }
}