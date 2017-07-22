package com.kishan.com.kishanapp

import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.R.attr.thumbnail
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import com.kishan.com.kishanapp.model.Contacts
import com.kishan.com.kishanapp.CardAdapter.MyViewHolder
import android.view.LayoutInflater




class CardAdapter(contexts : Context,contactList : ArrayList<Contacts> ) : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    var contexts : Context ?= null
    var contactList : ArrayList<Contacts> ?= null

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) , View.OnClickListener {
        var title: TextView


        init {
            title = view.findViewById(R.id.names)
            view.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
            var pos = layoutPosition
            var contact = contactList!!.get(pos)
            var intent = Intent(contexts,SenderProfile::class.java)
            contexts!!.startActivity(intent)
        }
    }

    init{
        this.contexts = contexts
        this.contactList = contactList
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent!!.getContext())
                .inflate(R.layout.cards, parent, false)

        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        var contacts = contactList!!.get(position)
        holder!!.title.setText(contacts.getName())

    }

    override fun getItemCount(): Int {
        return contactList!!.size
    }


}