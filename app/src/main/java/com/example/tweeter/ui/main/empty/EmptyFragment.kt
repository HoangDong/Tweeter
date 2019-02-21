package com.example.tweeter.ui.main.empty

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tweeter.R
import kotlinx.android.synthetic.main.fragment_empty.*

class EmptyFragment : Fragment() {
    companion object{
        private const val NAME = "name"
        fun newInstance(name: String):EmptyFragment{
            val bundle=Bundle()
            bundle.putString(NAME,name)
            val fragment = EmptyFragment()
            fragment.arguments=bundle
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_empty, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvName.text=arguments?.getString(NAME)

    }
}
