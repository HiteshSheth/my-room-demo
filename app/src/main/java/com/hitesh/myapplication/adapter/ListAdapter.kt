package com.hitesh.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hitesh.myapplication.R
import com.hitesh.myapplication.model.MainModel
import kotlinx.android.synthetic.main.user_data_row.view.*

class ListAdapter(val userList: List<MainModel.User>, val context: Context) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.user_data_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.txtName?.text = userList.get(position).userName
        holder?.txtMobile?.text = userList.get(position).mobile
        holder?.txtCity?.text = userList.get(position).city
    }

    class ViewHolder (view :View) : RecyclerView.ViewHolder(view){

        val txtName = view.txtName
        val txtMobile = view.txtMobile
        val txtCity = view.txtCity

    }
}