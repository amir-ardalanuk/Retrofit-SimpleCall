package com.example.myapplication.model.response

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class AppSetting(
    @SerializedName("appSettingModifiedDate")
    @Nullable
    var appSettingModifiedDate: String,
    @SerializedName("appSettingModifiedDateEpoch")
    @Nullable
    var appSettingModifiedDateEpoch: Int,
    @SerializedName("automaticRenewalCount")
    @Nullable
    var automaticRenewalCount: Int,
    @SerializedName("backupPhoneOffice")
    @Nullable
    var backupPhoneOffice: String,
    @SerializedName("canDecreasementConditionalPrice")
    @Nullable
    var canDecreasementConditionalPrice: Boolean,
    @SerializedName("currencyLabelCode")
    @Nullable
    var currencyLabelCode: Int,
    @SerializedName("currencyLabelName")
    @Nullable
    var currencyLabelName: String,
    @SerializedName("customerLoadingTypeId")
    @Nullable
    var customerLoadingTypeId: Int,
    @SerializedName("customerLoadingTypeName")
    @Nullable
    var customerLoadingTypeName: Any,
    @SerializedName("defaultDistanceFromDestination")
    @Nullable
    var defaultDistanceFromDestination: Int,
    @SerializedName("defaultDistanceFromOrigin")
    @Nullable
    var defaultDistanceFromOrigin: Int,
    @SerializedName("gigsInfo")
    @Nullable
    var gigsInfo: String,
    @SerializedName("gigsInfoImageUrl")
    @Nullable
    var gigsInfoImageUrl: String,
    @SerializedName("infoEmailAddress")
    @Nullable
    var infoEmailAddress: String,
    @SerializedName("instagramAddress")
    @Nullable
    var instagramAddress: String,
    @SerializedName("isChabokServiceEnable")
    @Nullable
    var isChabokServiceEnable: Boolean,
    @SerializedName("lengthValidationCode")
    @Nullable
    var lengthValidationCode: Int,
    @SerializedName("loadUnitCaption")
    @Nullable
    var loadUnitCaption: String,
    @SerializedName("maxOrderLoadWeight")
    @Nullable
    var maxOrderLoadWeight: Int,
    @SerializedName("maxPriceForSearch")
    @Nullable
    var maxPriceForSearch: Int,
    @SerializedName("maxTimeForCaseVoice")
    @Nullable
    var maxTimeForCaseVoice: String,
    @SerializedName("maximumDistanceFromDestination")
    @Nullable
    var maximumDistanceFromDestination: Int,
    @SerializedName("maximumDistanceFromOrigin")
    @Nullable
    var maximumDistanceFromOrigin: Int,
    @SerializedName("maximumFileSize")
    @Nullable
    var maximumFileSize: Int,
    @SerializedName("maximumValidityTime")
    @Nullable
    var maximumValidityTime: Int,
    @SerializedName("merchantNo")
    @Nullable
    var merchantNo: String,
    @SerializedName("minLenghtPassword")
    @Nullable
    var minLenghtPassword: Int,
    @SerializedName("minLengthDeliveryCode")
    @Nullable
    var minLengthDeliveryCode: Int,
    @SerializedName("minPriceForSearch")
    @Nullable
    var minPriceForSearch: Int,
    @SerializedName("officeAddress")
    @Nullable
    var officeAddress: String,
    @SerializedName("orderRegisterShowType")
    @Nullable
    var orderRegisterShowType: Int,
    @SerializedName("ratioCurrency")
    @Nullable
    var ratioCurrency: Int,
    @SerializedName("showAwards")
    @Nullable
    var showAwards: Boolean,
    @SerializedName("showCapacityType")
    @Nullable
    var showCapacityType: Boolean,
    @SerializedName("showCountNegotiate")
    @Nullable
    var showCountNegotiate: Boolean,
    @SerializedName("showCountView")
    @Nullable
    var showCountView: Boolean,
    @SerializedName("showDischargeTime")
    @Nullable
    var showDischargeTime: Boolean,
    @SerializedName("showGigsInfo")
    @Nullable
    var showGigsInfo: Boolean,
    @SerializedName("showInquiry")
    @Nullable
    var showInquiry: Boolean,
    @SerializedName("showMoreFilterInDriver")
    @Nullable
    var showMoreFilterInDriver: Boolean,
    @SerializedName("sliderInterval")
    @Nullable
    var sliderInterval: Int,
    @SerializedName("telegramAddress")
    @Nullable
    var telegramAddress: String,
    @SerializedName("terminalId")
    @Nullable
    var terminalId: String,
    @SerializedName("webAddress")
    @Nullable
    var webAddress: String
)