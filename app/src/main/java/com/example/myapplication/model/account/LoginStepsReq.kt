package com.example.myapplication.model.account

import com.google.gson.annotations.SerializedName
import com.example.myapplication.model.request.BaseRequestModel

data class LoginStepsReq(
    @SerializedName("mobilePhone")
    var mobilePhone: String? = null,
    @SerializedName("brokerCustomerId")
    var brokerCustomerId: Int? = null,
    @SerializedName("password")
    var password: String? = null
) : BaseRequestModel()