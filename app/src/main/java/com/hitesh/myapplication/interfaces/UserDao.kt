package com.hitesh.myapplication.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hitesh.myapplication.model.MainModel

@Dao
interface UserDao {

    @Query("select * from user")
    fun getAll(): List<MainModel.User>

    @Insert
    fun insertAll(vararg user:MainModel.User)
}