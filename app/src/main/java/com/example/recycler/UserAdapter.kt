package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val beseList: List<usermadel>):RecyclerView.Adapter<UserAdapter.ItemHolder>(){
    inner class ItemHolder(val view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_ly, parent,false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       val itemData=beseList[position]
        holder.itemView.findViewById<TextView>(R.id.text1).text = itemData.tex
        holder.itemView.findViewById<ImageView>(R.id.imageView).setImageResource(itemData.img)
    }

    override fun getItemCount(): Int {
      return beseList.size
    }
}
