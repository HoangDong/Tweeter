package com.example.tweeter.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.tweeter.data.model.Message
import io.reactivex.Flowable

@Dao
interface DaoMessage {
    @Insert
    fun insertMessages(messages: List<Message>)

    @Query("SELECT * FROM Message ORDER BY id DESC ")
    fun fetchAllMessages(): Flowable<List<Message>>
}