package com.example.recyclervieweducacionit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (val list: List<Product>, val listener: RecyclerViewClickListener, val clickListenerDelete: (Int) -> Unit ) : RecyclerView.Adapter<RecyclerViewHolder>(){

    interface RecyclerViewClickListener{
        fun onDetailClick(product: Product, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val layout = LayoutInflater.from(parent.context)
        return RecyclerViewHolder(layout.inflate(R.layout.view_for_products,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.paintItem(list[position], listener, position, clickListenerDelete)
    }

    override fun getItemCount(): Int = list.size
}