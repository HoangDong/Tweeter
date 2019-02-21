package com.example.tweeter.ui.post

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ObservableInt
import android.databinding.adapters.TextViewBindingAdapter
import android.util.Log
import com.example.base.viewmodel.BaseViewModel
import com.example.tweeter.data.local.AppDatabase
import com.example.tweeter.data.model.Message
import com.example.tweeter.utils.StringUtils
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class PostViewModel(private val mView:PostView, var dataBase: AppDatabase?) : BaseViewModel() {
    companion object {
        const val LIMIT_CHAR=50
    }
    val edtInput = ObservableField<String>("")
    val tvSweeter = ObservableField<String>("Sweeter")
    val inputSize=ObservableInt(LIMIT_CHAR)
    val enableTweeter=ObservableBoolean(false)
    lateinit var textSplitCache:Array<String>

    fun onTweetClicked() {
        try {
            val textSplit = StringUtils.splitMessage(edtInput.get().toString(), LIMIT_CHAR)
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
        }catch (e: IllegalArgumentException)
        {
            mView.onErrorInput(e.message?:"")
        }


    }

    fun onTextChanged(text: CharSequence?) {
        text?.let {
            enableTweeter.set(it.isNotEmpty())
            if(it.isEmpty()) {
                tvSweeter.set("Sweeter")
                return
            }
            inputSize.set(LIMIT_CHAR-it.length)
            try {
                textSplitCache = StringUtils.splitMessage(it.toString(), LIMIT_CHAR)
                if(textSplitCache.isNotEmpty())
                tvSweeter.set("Sweeter ${textSplitCache.size}")
            }catch (e:Exception){
                enableTweeter.set(false)
            }

        }

    }

    fun onCloseCLicked()
    {
        mView.onCloseClicked()
    }


}