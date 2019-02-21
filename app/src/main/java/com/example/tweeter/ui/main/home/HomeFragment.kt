package com.example.tweeter.ui.main.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.base.fragment.BaseMvvmFragment
import com.example.tweeter.BR
import com.example.tweeter.R
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.databinding.FragmentHomeBinding
import com.example.tweeter.utils.ActivityUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseMvvmFragment<FragmentHomeBinding, HomeViewModel>() {
    companion object {
        const val CR_POST = 101
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_home
    }

    override fun getViewModel(): HomeViewModel {
       return HomeViewModel(AppDatabase.getInstance(activity!!))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel?.getAllMessage()
        rvFeed.adapter=mViewModel?.mFeedAdapter
        cvPost.setOnClickListener { ActivityUtils.startPostActivity(this, CR_POST) }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK)
            mViewModel?.getAllMessage()
    }
}
