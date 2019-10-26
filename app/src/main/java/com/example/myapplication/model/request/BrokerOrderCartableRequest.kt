package com.example.myapplication.model.request

import com.google.gson.annotations.SerializedName

data class BrokerOrderCartableRequest(
    @SerializedName("brokerActionCode")
    var brokerActionCode: Int,
    @SerializedName("brokerCustomerId")
    var brokerCustomerId: Int,
    @SerializedName("filter")
    var filter: Filter?,
    @SerializedName("pageNumber")
    var pageNumber: Int?,
    @SerializedName("pageSize")
    var pageSize: Int?,
    @SerializedName("token")
    var token: String?
) : BaseRequestModel()