package com.example.myapplication.model.response

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class ResponseModel<T> {

    val gson = Gson()

    @SerializedName("success")
    @Expose
    var isSuccess: Boolean? = null


    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: T? = null

}
