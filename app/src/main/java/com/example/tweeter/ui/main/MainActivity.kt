package com.example.tweeter.ui.main

import android.os.Build
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.view.View
import com.example.base.acitivity.BaseActivity
import com.example.tweeter.R
import com.example.tweeter.ui.main.empty.EmptyFragment
import com.example.tweeter.ui.main.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private val mHomeFragment=HomeFragment()
    private val mEmptyFragment=EmptyFragment.newInstance("Empty")
    private var mFragmentActive:Fragment=mHomeFragment
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = getColor(R.color.colorBackgroundMain)
        }
        txtTitle.text=getString(R.string.home)
        initFragments()
        navMain.setOnNavigationItemSelectedListener(this)
    }

    private fun initFragments()
    {
        supportFragmentManager.beginTransaction().add(R.id.frmContainer, mHomeFragment, 1.toString()).commit()
        supportFragmentManager.beginTransaction().add(R.id.frmContainer, mEmptyFragment, 2.toString()).hide(mEmptyFragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        txtTitle.text=item.title
        when (item.itemId) {
            R.id.navHome -> showFragment(mHomeFragment)
            else -> showFragment(mEmptyFragment)
        }
        return true
    }

    private fun showFragment(frag:Fragment)
    {
        supportFragmentManager.beginTransaction().hide(mFragmentActive).show(frag).commit()
        mFragmentActive = frag
    }
}
