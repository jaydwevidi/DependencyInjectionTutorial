package com.example.dependencyinjectiontutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card.view.*

class MyRecyclerAdapter(val dataList: MutableList<Person> = arrayListOf()) : RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var name = itemView.textView
        var ID = itemView.textView2
        var photo = itemView.imageView
    }

    fun add( person: Person){
        dataList.add(person)
        notifyDataSetChanged()
    }

    fun clear(){
        dataList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card ,parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text =  dataList[position].name
        holder.ID.text =  dataList[position].age.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}