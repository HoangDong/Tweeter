package com.example.tweeter.ui.post

import android.os.Bundle
import com.example.base.acitivity.BaseMvvmActivity
import com.example.tweeter.BR
import com.example.tweeter.R
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.databinding.ActivityPostBinding
import android.app.Activity
import android.content.Intent



class PostActivity : BaseMvvmActivity<ActivityPostBinding,PostViewModel>(),PostView {
    override fun getViewModel(): PostViewModel {
        return  PostViewModel(this,AppDatabase.getInstance(this))
    }

    override fun getBindingVariable(): Int {
      return  BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_post
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onTweetSuccess() {
        setResult(Activity.RESULT_OK, Intent())
        finish()
    }
}
