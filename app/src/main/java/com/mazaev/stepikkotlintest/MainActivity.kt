package com.mazaev.stepikkotlintest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import com.mazaev.stepikkotlintest.model.Feed
import com.mazaev.stepikkotlintest.model.FeedItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var vRecView: RecyclerView
    val apiKey = "e957275cbc6649f8ba19d4ff7076b69f"
    val query = "news"
    val urlStr = "https://newsapi.org/v2/everything?q=$query&apiKey=$apiKey"

    var request: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vRecView = findViewById(R.id.recView)

        val obsObject = createRequest(urlStr)
            .map{Gson().fromJson(it, Feed::class.java)}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        request = obsObject.subscribe({

                //Log.w("test", "title: ${item.title}")
                showRecView(it.articles)

        },{
            Log.e("test", "",it)
        })


    }

    private fun showRecView(feedList: ArrayList<FeedItem>){
        vRecView.adapter = RecAdapter(feedList)
        vRecView.layoutManager = LinearLayoutManager(this)
    }

    override fun onDestroy(){
        request?.dispose()
        super.onDestroy()
    }
}



