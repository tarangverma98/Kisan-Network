package com.kishan.com.kishanapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class Splash : AppCompatActivity() {

    var gif : ImageView?= null
    var handlers : Handler?= null
    var runs = Runnable {
        var i = Intent (this@Splash,First::class.java)
        startActivity(i)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        gif = findViewById(R.id.images)
        handlers = Handler()

    }
}
