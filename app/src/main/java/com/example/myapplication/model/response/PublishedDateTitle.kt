package com.example.myapplication.model.response


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class PublishedDateTitle(
    @SerializedName("dayLeft")
    var dayLeft: Int,
    @SerializedName("houreLeft")
    var houreLeft: Int,
    @SerializedName("miniTitle")
    var miniTitle: String,
    @SerializedName("minuteLeft")
    var minuteLeft: Int,
    @SerializedName("title")
    var title: String
) : Parcelable