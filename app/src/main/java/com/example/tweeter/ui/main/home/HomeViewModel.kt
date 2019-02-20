package com.example.tweeter.ui.main.home

import android.arch.lifecycle.ViewModel
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.data.model.Message
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {
    private val messages = ArrayList<Message>()
    var mFeedAdapter = FeedAdapter(messages)

    fun getAllMessage(dataBase: AppDatabase?) {
        dataBase?.run {
            daoMessage().fetchAllMessages().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).doOnNext {
                    mFeedAdapter.updateMessages(it)
                }.subscribe()

        }
    }
}
