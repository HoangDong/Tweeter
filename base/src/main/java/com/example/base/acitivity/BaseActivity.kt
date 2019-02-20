package com.example.base.acitivity

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }


}