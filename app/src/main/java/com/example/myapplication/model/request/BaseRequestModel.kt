package com.example.myapplication.model.request


import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import okhttp3.MediaType
import okhttp3.RequestBody

open class BaseRequestModel {

    @SerializedName("appCode")
    var appCode: Int = 1

    @SerializedName("deviceTypeCode")
    var deviceTypeCode: Int = 1
}

fun BaseRequestModel.toRequestBody(): RequestBody {
    val json = Gson().toJson(this)
    val body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
    return body
}