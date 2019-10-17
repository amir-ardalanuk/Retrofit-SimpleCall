package com.example.myapplication.model.account


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "user")
data class UserAccount(val id : String?)  : Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "customerId")
    @SerializedName("customerId")
    var customerId: Int = 0
    @SerializedName("firstName")
    var firstName: String? = null
    @SerializedName("isExist")
    var  isExist: Boolean? = null
    @SerializedName("lastName")
    var lastName: String? = null
    @SerializedName("mobileVerified")
    var mobileVerified: Boolean? = null
    @SerializedName("senderNumber")
    var senderNumber: String? = null
    @SerializedName("jwtToken")
    var jwtToken: String? = null


}
