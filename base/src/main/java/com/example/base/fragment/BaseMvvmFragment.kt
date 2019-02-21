package com.example.base.fragment

import android.databinding.ViewDataBinding
import android.support.v4.app.Fragment
import com.example.base.viewmodel.BaseViewModel
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import com.example.base.acitivity.BaseActivity
import android.support.annotation.LayoutRes
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.os.Bundle
import android.support.annotation.Nullable
import android.databinding.DataBindingUtil
import android.support.annotation.NonNull
import android.view.ViewGroup
import android.view.LayoutInflater

abstract class BaseMvvmFragment<T : ViewDataBinding, V: BaseViewModel> : Fragment() {
    private var mRootView: View? = null
    private lateinit var mViewDataBinding: T
    var mViewModel: V? = null

    abstract fun getBindingVariable(): Int
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): V

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }
}