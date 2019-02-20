package com.example.tweeter.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import com.example.base.acitivity.BaseActivity
import com.example.base.extensions.replaceFragment
import com.example.tweeter.R
import com.example.tweeter.ui.main.empty.EmptyFragment
import com.example.tweeter.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navMain.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navHome -> replaceFragment(HomeFragment(), R.id.frmContainer)
            else -> replaceFragment(EmptyFragment.newInstance(item.title.toString()), R.id.frmContainer)
        }
        return true
    }
}
