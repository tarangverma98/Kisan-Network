package com.kishan.com.kishanapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide

class Splash : AppCompatActivity() {

    var gif : ImageView?= null
    var handlers : Handler?= null
    var runs = Runnable {
        var i = Intent (this@Splash,First::class.java)
        startActivity(i)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        gif = findViewById(R.id.images)
        Glide.with(this@Splash).asGif().load(R.drawable.splash).into(gif)
        handlers = Handler()
        handlers!!.postDelayed(runs,5000)
    }
}
