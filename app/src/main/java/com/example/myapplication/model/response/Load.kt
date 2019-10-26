package com.example.myapplication.model.response

import com.google.gson.annotations.SerializedName
import androidx.annotation.Nullable


data class Load(
    @SerializedName("approvedCount")
    @Nullable
    var approvedCount: Int?,
    @SerializedName("averageAmount")
    @Nullable
    var averageAmount: Int?,
    @SerializedName("billOfLadingCode")
    @Nullable
    var billOfLadingCode: Int?,
    @SerializedName("billOfLadingTitle")
    @Nullable
    var billOfLadingTitle: String?,
    @SerializedName("canCancel")
    @Nullable
    var canCancel: Boolean?,
    @SerializedName("canCarsNumberRequested")
    @Nullable
    var canCarsNumberRequested: Boolean?,
    @SerializedName("canChangePrice")
    @Nullable
    var canChangePrice: Boolean?,
    @SerializedName("canEdit")
    @Nullable
    var canEdit: Boolean?,
    @SerializedName("canPublish")
    @Nullable
    var canPublish: Boolean?,
    @SerializedName("canShowTrackingCode")
    @Nullable
    var canShowTrackingCode: Boolean?,
    @SerializedName("canStopNegotiate")
    @Nullable
    var canStopNegotiate: Boolean?,
    @SerializedName("capacityTypeCode")
    @Nullable
    var capacityTypeCode: Int?,
    @SerializedName("capacityTypeTitle")
    @Nullable
    var capacityTypeTitle: String?,
    @SerializedName("carsNumberRequested")
    @Nullable
    var carsNumberRequested: Int?,
    @SerializedName("createdOn")
    @Nullable
    var createdOn: String?,
    @SerializedName("createdOnEpoch")
    @Nullable
    var createdOnEpoch: Int?,
    @SerializedName("customerProposedPrice")
    @Nullable
    var customerProposedPrice: Int?,
    @SerializedName("deliveryCount")
    @Nullable
    var deliveryCount: Int?,
    @SerializedName("descriptionCount")
    @Nullable
    var descriptionCount: String?,
    @SerializedName("destinationCityTitle")
    @Nullable
    var destinationCityTitle: String?,
    @SerializedName("destinationSpan")
    @Nullable
    var destinationSpan: Any?,
    @SerializedName("dischargeDate")
    @Nullable
    var dischargeDate: String?,
    @SerializedName("dischargeDateEpoch")
    @Nullable
    var dischargeDateEpoch: Int?,
    @SerializedName("dischargeTime")
    @Nullable
    var dischargeTime: Any?,
    @SerializedName("dischargeTimeTypeCode")
    @Nullable
    var dischargeTimeTypeCode: Int?,
    @SerializedName("dischargeTimeTypeTitle")
    @Nullable
    var dischargeTimeTypeTitle: String?,
    @SerializedName("driverCount")
    @Nullable
    var driverCount: Int?,
    @SerializedName("isStopNegotiate")
    @Nullable
    var isStopNegotiate: Boolean?,
    @SerializedName("ladingDate")
    @Nullable
    var ladingDate: String?,
    @SerializedName("ladingDateEpoch")
    @Nullable
    var ladingDateEpoch: Int?,
    @SerializedName("ladingTime")
    @Nullable
    var ladingTime: Any?,
    @SerializedName("loadTypeTitle")
    @Nullable
    var loadTypeTitle: String?,
    @SerializedName("loadWeight")
    @Nullable
    var loadWeight: Double?,
    @SerializedName("loadingCount")
    @Nullable
    var loadingCount: Int?,
    @SerializedName("loadingTypeId1")
    @Nullable
    var loadingTypeId1: Int?,
    @SerializedName("loadingTypeId2")
    @Nullable
    var loadingTypeId2: Int?,
    @SerializedName("loadingTypeId3")
    @Nullable
    var loadingTypeId3: Int?,
    @SerializedName("loadingTypeName1")
    @Nullable
    var loadingTypeName1: String?,
    @SerializedName("loadingTypeName2")
    @Nullable
    var loadingTypeName2: Any?,
    @SerializedName("loadingTypeName3")
    @Nullable
    var loadingTypeName3: Any?,
    @SerializedName("negotiationCount")
    @Nullable
    var negotiationCount: Int?,
    @SerializedName("newNegotiationColor")
    @Nullable
    var newNegotiationColor: String?,
    @SerializedName("orderId")
    @Nullable
    var orderId: String?,
    @SerializedName("orderNegotiateTitle")
    @Nullable
    var orderNegotiateTitle: String?,
    @SerializedName("orderNegotiateTitleColor")
    @Nullable
    var orderNegotiateTitleColor: String?,
    @SerializedName("originCityId")
    @Nullable
    var originCityId: Int?,
    @SerializedName("originCityTitle")
    @Nullable
    var originCityTitle: String?,
    @SerializedName("originSpan")
    @Nullable
    var originSpan: String?,
    @SerializedName("packageTypeTitle")
    @Nullable
    var packageTypeTitle: String?,
    @SerializedName("processCount")
    @Nullable
    var processCount: Int?,
    @SerializedName("publishedDate")
    @Nullable
    var publishedDate: String?,
    @SerializedName("publishedDateEpoch")
    @Nullable
    var publishedDateEpoch: Int?,
    @SerializedName("publishedDateTitle")
    @Nullable
    var publishedDateTitle: PublishedDateTitle?,
    @SerializedName("remainCarCount")
    @Nullable
    var remainCarCount: Int?,
    @SerializedName("senderMobilePhone")
    @Nullable
    var senderMobilePhone: String?,
    @SerializedName("senderName")
    @Nullable
    var senderName: String?,
    @SerializedName("serverMessage")
    @Nullable
    var serverMessage: Any?,
    @SerializedName("shippingCount")
    @Nullable
    var shippingCount: Int?,
    @SerializedName("showAverageAmount")
    @Nullable
    var showAverageAmount: Boolean?,
    @SerializedName("sumAmount")
    @Nullable
    var sumAmount: Int?,
    @SerializedName("totalPrice")
    @Nullable
    var totalPrice: Int?,
    @SerializedName("tr")
    @Nullable
    var tr: Int?,
    @SerializedName("trackingCode")
    @Nullable
    var trackingCode: String?,
    @SerializedName("transfereeMobilePhone")
    @Nullable
    var transfereeMobilePhone: String?,
    @SerializedName("transfereeName")
    @Nullable
    var transfereeName: String?,
    @SerializedName("viewCount")
    @Nullable
    var viewCount: Int
)