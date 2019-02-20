package com.example.tweeter.ui.main.home

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.tweeter.R
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.utils.ActivityUtils
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    companion object {
        const val CR_POST = 101
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.getAllMessage(AppDatabase.getInstance(activity!!))
        rvFeed.adapter = viewModel.mFeedAdapter
        cvPost.setOnClickListener { ActivityUtils.startPostActivity(this, CR_POST) }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK)
            viewModel.getAllMessage(AppDatabase.getInstance(activity!!))
    }
}
