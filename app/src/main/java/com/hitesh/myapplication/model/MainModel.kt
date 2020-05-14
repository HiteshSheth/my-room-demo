package com.hitesh.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class MainModel{

    @Entity
    data class User(
        @PrimaryKey(autoGenerate = true) val uid: Int,
        @ColumnInfo(name = "userName" )val userName:String?,
        @ColumnInfo(name = "mobile" )val mobile:String?,
        @ColumnInfo(name = "city")val city:String?
    )
}