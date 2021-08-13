package com.example.myapplication

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), nic {

private lateinit var mAdapter: CustomAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      fdata()

        rview.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        mAdapter = CustomAdapter(this)
        rview.adapter = mAdapter;
        rview.layoutManager = LinearLayoutManager(this);


    }
    private  fun fdata ()
    {
        val url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json"

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
            {

            }
        )

// Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun Onitemclicked(item: news) {

      val builder =  CustomTabsIntent.Builder();
      val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(item.url));




    }

}