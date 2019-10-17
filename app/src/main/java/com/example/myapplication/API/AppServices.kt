package com.example.myapplication.API

import com.example.myapplication.API.Route.AccountServicesInterface
import com.example.myapplication.API.Route.ApiService
import com.example.myapplication.API.Route.GeneralService
import com.example.myapplication.API.Route.OrderServices
import retrofit2.create

enum class URL {
    home , login;
    companion object BASE{
        val baseurl = "https://customerapi.patoughi.com/"
    }
}
fun ApiServices(): ApiService {
    val api : ApiService =  ApiClient.getClient(null,URL.baseurl).create()
    return api
}

fun AccountServices(): AccountServicesInterface {

    val accountEndPoint = "C/BrokerAccount/"
    return  ApiClient.getClient(null,URL.baseurl + accountEndPoint).create()
}

fun BrokerOrderServices(): OrderServices{
    val accountEndPoint = "/C/BrokerOrder/"
    return  ApiClient.getClient(null,URL.baseurl + accountEndPoint).create()
}

fun GeneralServices(): GeneralService{
    val midPoint = "/General/"
    return  ApiClient.getClient(null,URL.baseurl + midPoint).create()
}

fun <T:Class<T>> ApiCallFactroy(t:T , middlePoint: String?) : T  {

    return  ApiClient.getClient(null,URL.baseurl + (middlePoint?:"")).create(t)
}