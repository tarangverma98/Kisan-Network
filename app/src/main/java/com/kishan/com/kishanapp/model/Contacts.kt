package com.kishan.com.kishanapp.model



class Contacts {

    private var id: String? = null
    private var name: String ?= null
    private var phone_number: String ?= null


    fun getName(): String ?{
        return name
    }

    fun setName(name: String) {
        this.name = name
    }


    fun setPhoneNumber(phone_number: String) {
        this.phone_number = phone_number
    }

    fun getPhoneNumber(): String ?{
        return phone_number
    }


}