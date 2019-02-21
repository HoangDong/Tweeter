package com.example.tweeter.ui.main.home

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.tweeter.BR
import com.example.tweeter.data.model.Message
import com.example.tweeter.databinding.ItemFeedBinding
import com.example.tweeter.R


class FeedAdapter(private val mMessages: ArrayList<Message>) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemFeedBinding>(layoutInflater, R.layout.item_feed, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mMessages.count()
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(mMessages[position])
    }

    fun updateMessages(messages: List<Message>) {
        val diffCallback = FeedDiffUtil(mMessages, messages)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        mMessages.clear()
        mMessages.addAll(messages)
        diffResult.dispatchUpdatesTo(this)
    }
    class ViewHolder(private val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {
            binding.setVariable(BR.item, item)
            binding.executePendingBindings()
        }
    }
}