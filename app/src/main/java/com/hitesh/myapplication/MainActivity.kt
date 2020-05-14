package com.hitesh.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.hitesh.myapplication.adapter.ListAdapter
import com.hitesh.myapplication.model.MainModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db:AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "myDb"
        ).allowMainThreadQueries().build()

        initFun()
    }

    fun initFun(){

        val userList = db!!.userDao().getAll()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(userList, this)

        floatingActionAdd.setOnClickListener({

            var intentAddItem = Intent(this, AddActivity::class.java)
            this.startActivity(intentAddItem)
        })
    }
}
