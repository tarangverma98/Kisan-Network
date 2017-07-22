package com.kishan.com.kishanapp

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.kishan.com.kishanapp.fragments.FirstFragment
import com.kishan.com.kishanapp.fragments.SecondFragment


class First :AppCompatActivity() {

    var toolbars : Toolbar?= null
    var viewPagers : ViewPager ?= null
    var pager : MyPagerAdapter ?= null
    var tabs : TabLayout?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first)

        //toolbar configuration
        toolbars = findViewById(R.id.toolbar)
        setSupportActionBar(toolbars)

        //PagerAdapter configuration
        pager = MyPagerAdapter(supportFragmentManager)

        // TabLayout Configuration
        tabs = findViewById(R.id.tabs)

        //viewpager configuration
        viewPagers = findViewById(R.id.container)
        setUpWithViewPager()

        tabs!!.setupWithViewPager(viewPagers)


    }


    private fun setUpWithViewPager(){
        pager!!.addFragment(FirstFragment(),"List")
        pager!!.addFragment(SecondFragment(),"More")
        viewPagers!!.setAdapter(pager)
    }
}