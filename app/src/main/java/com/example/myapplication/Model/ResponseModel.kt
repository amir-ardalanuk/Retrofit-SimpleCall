package com.example.myapplication.Model

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

open class ResponseModel<T> {

    val gson = Gson()

    @SerializedName("isSuccess")
    @Expose
    var isSuccess: Boolean? = null


    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: T? = null

}
