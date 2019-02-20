package com.example.tweeter.ui.main.home

import android.support.v7.util.DiffUtil
import com.example.tweeter.data.model.Message

class FeedDiffUtil(val mOldFeedList: List<Message>, val mNewFeedList: List<Message>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldFeedList[oldItemPosition].id==mNewFeedList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
       return mOldFeedList.size
    }

    override fun getNewListSize(): Int {
       return mNewFeedList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val  old = mOldFeedList[oldItemPosition]
        val  new = mNewFeedList[newItemPosition]
       return old.name==new.name && old.message==new.message && old.time==new.time
    }





}