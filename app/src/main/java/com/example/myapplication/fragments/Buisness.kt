package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import android.net.Uri
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.myapplication.*
import com.example.newsfresh.MySingleton
import kotlinx.android.synthetic.main.fragment_buisness.view.*
import kotlinx.android.synthetic.main.fragment_entertainment.view.*
import kotlinx.android.synthetic.main.fragment_health.view.*
import kotlinx.android.synthetic.main.fragment_science.view.*

class Buisness : Fragment(),nic {
    private lateinit var mAdapter: CustomAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_buisness, container, false)
        view.rview3.layoutManager = LinearLayoutManager(view.context)
        view.rview3.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
        fdata()
        mAdapter = CustomAdapter(this)
        view.rview3.adapter = mAdapter


        return view
    }

    override fun Onitemclicked(news: news) {
        val builder =  CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        view?.context?.let { customTabsIntent.launchUrl(it, Uri.parse(news.url)) }
    }

    fun fdata ()
    {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/general/in.json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            {
                val newsJasonArry = it.getJSONArray("articles")
                val nearr = ArrayList<news>()
                for (i in 0 until newsJasonArry.length()) {
                    val newsjason = newsJasonArry.getJSONObject(i);
                    val neews = news(
                        newsjason.getString("title"),
                        newsjason.getString("author"),
                        newsjason.getString("url"),
                        newsjason.getString("urlToImage")
                    )
                    nearr.add(neews)

                }

                mAdapter.updatenews(nearr)
            },
            Response.ErrorListener {

            }
        )

        MySingleton.getInstance(this.requireContext()).addToRequestQueue(jsonObjectRequest)
    }
}

