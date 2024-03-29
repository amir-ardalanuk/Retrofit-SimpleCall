package com.example.myapplication.API.CustomAdapter

import com.example.myapplication.API.ApiServices
import com.example.myapplication.Model.RegisterModel
import com.example.myapplication.Model.ResponseModel
import com.google.gson.Gson
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Buffer

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException

class Simple<R>(private val call : Call<R>){


    //sync Api Call
    fun run(responseHandler :(R?,Throwable?)->Unit){
        try{
            val response = call.execute()
            handelResponse(response,responseHandler)
        }catch (t: IOException){
            responseHandler(null,t)
        }

    }

    // Async Api Call
    fun process(responseHandler: (R?, Throwable?) -> Unit):Subscription{


        val subscription = Subscription()
        val callback = object : Callback<R> {
            override fun onFailure(call: Call<R>, t: Throwable) {
                if (!subscription.isDisposed())
                responseHandler(null,t)
            }
            override fun onResponse(call: Call<R>, response: Response<R>) {
                if (!subscription.isDisposed())
                handelResponse( response,responseHandler)
            }
        }
        call.enqueue(callback)
        return subscription
    }

    //Async Api call For Java Classes
    fun processJV(responseHandler: SimpleJavaInterface<R>){
        val callback = object : Callback<R> {
            override fun onFailure(call: Call<R>, t: Throwable) {
              responseHandler.accept(null,t)
            }

            override fun onResponse(call: Call<R>, response: Response<R>) {
                handelResponseJava(response,responseHandler)
            }
        }
        call.enqueue(callback)

    }
    private fun handelResponseJava(response : Response<R>,handler: SimpleJavaInterface<R>){

        if(response.isSuccessful){
            handler.accept(response.body(),null)
        }else{
            if(response.code() in 400..500)
                handler.accept(null,HttpException(response))
            else
                handler.accept(response.body(),null)
        }
    }

    //Handel returned data from request
    private fun handelResponse(response : Response<R>,handler: (R?,Throwable?)->Unit){

        if(response.isSuccessful){
            handler(response.body(),null)
        }else{
            when(response.code()) {
                400 -> getNewToken(handler, response)
                in 401..500 -> errorHandler(response, handler)
                else -> handler(response.body(),UnknownHostException("Somthing is wrong try again"))
            }
        }
    }

//
    private fun getNewToken(handler: (R?, Throwable?) -> Unit, response: Response<R>) {
        reAuthenticate { newToken, error ->
            when {
                newToken != null -> process(handler)
                else -> errorHandler(response, handler)
            }
        }
    }

    private  fun errorHandler(response : Response<R>,handler: (R?,Throwable?)->Unit){
        val body = response.errorBody()?.pareseErrorBody()
        if(body != null)
            handler(null, Exception(body.message ))
        else
            handler(null, HttpException(response))
    }

    private fun reAuthenticate(newToken : ((String?,Throwable?) -> Unit)){

        ApiServices()
            .refreshToken(RegisterModel("","","")).process { responseModel, throwable ->
            val token = responseModel?.data

            when{
                token != null -> newToken(token.token,null)
                else -> newToken(null,throwable)
            }
        }
    }

    private fun ResponseBody?.pareseErrorBody() : ResponseModel<*>? {
        val gson = Gson()
        val jsonString = this?.string()
        if(jsonString != null){
            return gson.fromJson(jsonString,ResponseModel :: class.java)
        }else return null
    }



}