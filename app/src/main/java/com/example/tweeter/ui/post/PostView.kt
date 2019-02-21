package com.example.tweeter.ui.post

interface PostView {
    fun onTweetSuccess()
    fun onErrorInput(error:String)
    fun onCloseClicked()
}