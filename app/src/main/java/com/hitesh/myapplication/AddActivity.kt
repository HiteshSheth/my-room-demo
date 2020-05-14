package com.hitesh.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Database
import androidx.room.Room
import com.hitesh.myapplication.model.MainModel
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    var db:AppDatabase? = null

    //This is demo
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

         db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "myDb"
        ).allowMainThreadQueries().build()

        setClicks()

    }

    fun setClicks(){

        btnAdd.setOnClickListener({

            var varName = edtName.text.toString()
            var varMobile = edtMobile.text.toString()
            var varCity = edtCity.text.toString()
            var varId = edtId.text.toString()

            if(varId.length <= 0){
                edtId.requestFocus()
                Toast.makeText(this, "Please enter Id", Toast.LENGTH_LONG).show()

            } else if(varName.length <= 0){
                edtName.requestFocus()
                Toast.makeText(this, "Please enter Name", Toast.LENGTH_LONG).show()

            } else if(varMobile.length <= 0){
                edtMobile.requestFocus()
                Toast.makeText(this, "Please enter Mobile", Toast.LENGTH_LONG).show()

            } else if(varCity.length <= 0){
                edtCity.requestFocus()
                Toast.makeText(this, "Please enter City", Toast.LENGTH_LONG).show()
            } else {

                var userModel = MainModel.User(Integer.parseInt(varId), varName, varMobile,varCity)
                db!!.userDao().insertAll(userModel)
                Toast.makeText(this, "Successful user inserted", Toast.LENGTH_LONG).show()
                finish()
            }
        })
    }
}
