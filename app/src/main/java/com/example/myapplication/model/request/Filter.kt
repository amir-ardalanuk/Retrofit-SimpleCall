package com.example.myapplication.model.request

import com.google.gson.annotations.SerializedName

data class Filter(
    @SerializedName("createdOnFrom")
    var createdOnFrom: String,
    @SerializedName("createdOnFromEpoch")
    var createdOnFromEpoch: Int,
    @SerializedName("createdOnTo")
    var createdOnTo: String,
    @SerializedName("createdOnToEpoch")
    var createdOnToEpoch: Int,
    @SerializedName("customerProposedPriceFrom")
    var customerProposedPriceFrom: Int,
    @SerializedName("customerProposedPriceTo")
    var customerProposedPriceTo: Int,
    @SerializedName("destinationCityId")
    var destinationCityId: Int,
    @SerializedName("dischargeDateFrom")
    var dischargeDateFrom: String,
    @SerializedName("dischargeDateFromEpoch")
    var dischargeDateFromEpoch: Int,
    @SerializedName("dischargeDateTo")
    var dischargeDateTo: String,
    @SerializedName("dischargeDateToEpoch")
    var dischargeDateToEpoch: Int,
    @SerializedName("hasNegotiate")
    var hasNegotiate: Boolean,
    @SerializedName("ladingDateFrom")
    var ladingDateFrom: String,
    @SerializedName("ladingDateFromEpoch")
    var ladingDateFromEpoch: Int,
    @SerializedName("ladingDateTo")
    var ladingDateTo: String,
    @SerializedName("ladingDateToEpoch")
    var ladingDateToEpoch: Int,
    @SerializedName("loadWeight")
    var loadWeight: Int,
    @SerializedName("loadingTypeId")
    var loadingTypeId: Int,
    @SerializedName("orderRecommenderName")
    var orderRecommenderName: String,
    @SerializedName("orderRecommenderTypeCode")
    var orderRecommenderTypeCode: Int,
    @SerializedName("packageTypeId")
    var packageTypeId: Int,
    @SerializedName("quickSearch")
    var quickSearch: String,
    @SerializedName("trackingCode")
    var trackingCode: String
)