package com.example.assignment5

import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.ArrayList

class MyAdapter(
    private  var context: Context,
    private  var nameId: ArrayList<String>,
    private  var authorId: ArrayList<String>,
    private  var yearId: ArrayList<String>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.userentry,parent,false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var nameId : TextView
        lateinit var authorId : TextView
        lateinit var yearId : TextView







    }


}