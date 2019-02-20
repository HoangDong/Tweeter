package com.example.tweeter.ui.post

import android.databinding.ObservableField
import com.example.base.viewmodel.BaseViewModel
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.data.model.Message
import com.example.tweeter.utils.StringUtils
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

class PostViewModel(val mView:PostView,var dataBase: AppDatabase?) : BaseViewModel() {

    val edtInput = ObservableField<String>("")
    fun onTweetClicked() {
        val textSplit = StringUtils.splitMessage(edtInput.get().toString(), 50)
        val listMessage = ArrayList<Message>()
        for (text in textSplit) {
            listMessage.add(Message(0, "DongHoang", "Today", text))

        }
        dataBase?.run {
            Completable.fromAction {
                daoMessage().insertMessages(listMessage)
            }.subscribeOn(Schedulers.io()).doOnComplete {
                mView.onTweetSuccess()
            }.subscribe()
        }

    }
}