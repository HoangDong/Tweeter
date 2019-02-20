package com.example.tweeter.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.tweeter.data.model.Message
import android.arch.persistence.room.Room



@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private const val DB_NAME = "appDatabase.db"
        @Volatile private var instance: AppDatabase? = null
        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME
            ).build()
        }
    }
    abstract fun daoMessage(): DaoMessage
}