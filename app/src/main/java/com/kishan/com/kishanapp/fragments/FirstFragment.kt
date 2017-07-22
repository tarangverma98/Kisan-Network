package com.kishan.com.kishanapp.fragments

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kishan.com.kishanapp.CardAdapter
import com.kishan.com.kishanapp.R
import com.kishan.com.kishanapp.model.Contacts
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.IOException


class FirstFragment : Fragment() {

    var views : View ?= null
    var contexts : Context?= null
    var recycler : RecyclerView ?= null
    var contactList : ArrayList<Contacts> ?= null
    var cards : CardAdapter ? =null
    var recyclerLinearManager : LinearLayoutManager ?= null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        views = inflater!!.inflate(R.layout.maincontent,container,false)
        contactList = ArrayList()
        loadJson()
        recycler = views!!.findViewById(R.id.recycler)
        recycler!!.setHasFixedSize(true)
        contexts = activity
        recyclerLinearManager = LinearLayoutManager(activity)
        recycler!!.setLayoutManager(recyclerLinearManager)
        cards = CardAdapter(contexts !!,contactList !!)
        recycler!!.setAdapter(cards)
        return views
    }

    // Load Json file from raw  folder
    private fun loadJson() {
        val inputStream = resources.openRawResource(R.raw.contacts)
        val byteArrayOutputStream = ByteArrayOutputStream()
        var ctr: Int
        try {
            ctr = inputStream.read()
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr)
                ctr = inputStream.read()
            }
            inputStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        try {

            // Parse the data into jsonobject to get original data in form of json.
           /* val jObject = JSONObject(
                    byteArrayOutputStream.toString())
            val jObjectResult = jObject.getJSONObject("Categories")
            val jArray = jObjectResult.getJSONArray("Category")*/
            val jsonArray = JSONArray(byteArrayOutputStream.toString())
            var cat_Id = ""
            var cat_name = ""

            for (i in 0..jsonArray.length() - 1) {

                cat_Id = jsonArray.getJSONObject(i).getString("name")
                cat_name = jsonArray.getJSONObject(i).getString("phone_number")
                var contacts = Contacts()
                contacts.setName(cat_Id)
                contacts.setPhoneNumber(cat_name)
                contactList!!.add(contacts)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}