package com.example.tweeter.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Message(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name:String,
    var time:String,
    var message:String
)