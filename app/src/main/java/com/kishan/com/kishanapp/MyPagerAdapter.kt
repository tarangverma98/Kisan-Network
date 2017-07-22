package com.kishan.com.kishanapp

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.kishan.com.kishanapp.fragments.FirstFragment
import com.kishan.com.kishanapp.fragments.SecondFragment


class MyPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    var list = ArrayList<Fragment>()
    var names = ArrayList<String>()

    fun addFragment(fragments : Fragment, name : String){
     list.add(fragments)
        names.add(name)
    }

    override fun getItem(position: Int): Fragment {

      return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence {

       return names.get(position)
    }
}