package com.example.myapplication.model.response


import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import androidx.annotation.Nullable


data class ListResponse<T>(
    @SerializedName("currentPageNumber")
    @Nullable
    var currentPageNumber: Int?,
    @SerializedName("items")
    @Nullable
    var items: List<T>?,
    @SerializedName("pageSize")
    @Nullable
    var pageSize: Int?,
    @SerializedName("totalRecords")
    @Nullable
    var totalRecords: Int?
)