package com.example.tweeter.ui.main.home

import android.databinding.ObservableBoolean
import com.example.base.viewmodel.BaseViewModel
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.data.model.Message
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val dataBase: AppDatabase?) : BaseViewModel() {
    private val messages = ArrayList<Message>()
    var mFeedAdapter = FeedAdapter(messages)
    var noData=ObservableBoolean(false)

    fun getAllMessage() {
        dataBase?.run {
            daoMessage().fetchAllMessages().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    mFeedAdapter.updateMessages(it)
                    noData.set(it.isEmpty())
                },{})

        }
    }
}
