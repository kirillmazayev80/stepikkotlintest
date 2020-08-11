package com.mazaev.stepikkotlintest

import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.mazaev.stepikkotlintest.model.FeedItem
import com.squareup.picasso.Picasso

class RecHolder(view: View): RecyclerView.ViewHolder(view){

    fun bind(item: FeedItem) {
        val vTitle = itemView.findViewById<TextView>(R.id.item_title)
        val vDescr = itemView.findViewById<TextView>(R.id.item_descr)
        val vThumb = itemView.findViewById<ImageView>(R.id.item_thumb)
        vTitle.text = item.title
        vDescr.text = item.description
        if  (!item.urlToImage.isEmpty()) {
            Picasso.with(vThumb.context).load(item.urlToImage).into(vThumb)
        }

        itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            val context = vThumb.context
            startActivity(context, intent, null)
        }
    }

}