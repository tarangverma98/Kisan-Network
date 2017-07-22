package com.kishan.com.kishanapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kishan.com.kishanapp.R

/**
 * Created by tarang on 22/7/17.
 */
class SecondFragment : Fragment() {

    var views : View ?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        views = inflater!!.inflate(R.layout.secondfragment,container,false)
        return views
    }
}