package com.example.roomdatabase.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(version = 1, entities = [User::class], exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getUserDao():UserDao
    companion object{
        @Volatile
        private var instances:AppDatabase?=null
        private val LOCK=Any()
        operator fun invoke(context: Context)= instances?: synchronized(LOCK){
            instances?: buildDatabase(context).also {
                instances= it
            }
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app-database"

        ).build()
    }

}