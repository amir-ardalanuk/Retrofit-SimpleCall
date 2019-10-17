package com.example.myapplication.model.response

class UserResponse : ResponseModel<User>(){}
data class User(val token :String?,val userProperties : UserPropertis? ){

}
data class  UserPropertis(val _id:String?,val isExpire : Boolean? , val email : String?)