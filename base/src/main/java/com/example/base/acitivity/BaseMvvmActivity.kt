package com.example.base.acitivity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.Nullable
import android.support.v7.app.AppCompatActivity
import com.example.base.viewmodel.BaseViewModel


abstract class BaseMvvmActivity<T : ViewDataBinding, V: BaseViewModel> : BaseActivity() {
    private lateinit var mViewDataBinding: T
    var mViewModel: V? = null

    abstract fun getViewModel(): V
    abstract fun getBindingVariable(): Int

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = mViewModel ?: getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

}