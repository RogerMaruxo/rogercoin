package com.cat.rogercoin.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cat.rogercoin.data.database.dao.ExchangeDao
import com.cat.rogercoin.data.model.ExchangeResponseValue

@Database(entities = [ExchangeResponseValue::class],version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exchangeDao(): ExchangeDao

    companion object {
        fun getInstance(context: Context) : AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "exchange_app_db"
            ).build()
        }
    }
}