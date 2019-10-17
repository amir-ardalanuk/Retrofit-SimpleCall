package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EnumsName(
    @SerializedName("name")
    var name: String?,
    @SerializedName("needUIAction")
    var needUIAction: Boolean?,
    @SerializedName("value")
    var value: Int?
) : Serializable