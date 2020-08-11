package com.mazaev.stepikkotlintest.model

class Feed {
    val articles = ArrayList<FeedItem>()
}

data class FeedItem (
    val title: String,
    val url: String,
    val urlToImage: String,
    val description: String
)