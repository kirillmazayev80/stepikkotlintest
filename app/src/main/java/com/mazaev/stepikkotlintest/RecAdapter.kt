package com.mazaev.stepikkotlintest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mazaev.stepikkotlintest.model.FeedItem

class RecAdapter(val items: ArrayList<FeedItem>): RecyclerView.Adapter<RecHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecHolder {
        val inflater = LayoutInflater.from(parent!!.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return RecHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecHolder?, position: Int) {
        val item = items[position]
        holder?.bind(item)
    }

}