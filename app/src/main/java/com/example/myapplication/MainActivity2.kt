package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val backgroundImage: ImageView = findViewById(R.id.imageView2)
        val tview :TextView = findViewById(R.id.tv1)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.file1anim)
        val slideAnimation2 = AnimationUtils.loadAnimation(this, R.anim.file2anim)
        backgroundImage.startAnimation(slideAnimation)
         tview.startAnimation(slideAnimation2)
        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            val intent = Intent(this, newsAcc::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 3000 is the delayed time in milliseconds.
    }
}