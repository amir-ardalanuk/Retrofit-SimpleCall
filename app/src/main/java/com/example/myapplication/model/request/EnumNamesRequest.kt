package com.example.myapplication.model.request

import com.google.gson.annotations.SerializedName

data class EnumNamesRequest(
    @SerializedName("enumName")
    var enumName: String? = null
) : BaseRequestModel()