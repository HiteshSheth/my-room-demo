package com.hitesh.myapplication

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hitesh.myapplication.interfaces.UserDao
import com.hitesh.myapplication.model.MainModel

@Database(entities = arrayOf(MainModel.User::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
}