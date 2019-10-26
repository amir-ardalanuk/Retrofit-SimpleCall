package com.example.myapplication.utils

import com.google.gson.Gson

fun <T> ArrayList<T>.convertToString():String? {
    val gson = Gson()
    val json = gson.toJson(this)
    return json
}