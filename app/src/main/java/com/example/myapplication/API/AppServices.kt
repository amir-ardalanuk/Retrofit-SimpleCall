package com.example.myapplication.API

import android.content.Context
import retrofit2.create

enum class URL {
    home , login;
    companion object BASE{
        val baseurl = "http:/192.168.135.35:3000/api/"
    }
}
fun ApiServices(): ApiService {
    val api : ApiService =  ApiClient.getClient(null,URL.baseurl).create()
    return api
}
