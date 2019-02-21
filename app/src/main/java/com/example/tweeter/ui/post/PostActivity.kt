package com.example.tweeter.ui.post

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.base.acitivity.BaseMvvmActivity
import com.example.tweeter.BR
import com.example.tweeter.R
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.databinding.ActivityPostBinding

class PostActivity : BaseMvvmActivity<ActivityPostBinding,PostViewModel>(),PostView {
    override fun getViewModel(): PostViewModel {
        return  PostViewModel(this,AppDatabase.getInstance(this))
    }

    override fun getBindingVariable(): Int {
      return  BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = getColor(R.color.colorBackgroundMain)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_post
    }

    override fun onErrorInput(error: String) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show()
    }

    override fun onCloseClicked() {
        finish()
    }
    override fun onTweetSuccess() {
        setResult(Activity.RESULT_OK, Intent())
        finish()
    }
}
