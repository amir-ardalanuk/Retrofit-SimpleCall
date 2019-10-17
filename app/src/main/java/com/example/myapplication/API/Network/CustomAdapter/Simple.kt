package com.example.myapplication.API.Network.CustomAdapter

import com.example.myapplication.API.ApiServices
import com.example.myapplication.model.RegisterModel
import com.example.myapplication.model.response.ResponseModel
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

import okhttp3.ResponseBody

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class NoConnection(message:String): Exception(message)

class Simple<R>(private val call : Call<R>){


    //sync Api Call
    fun run():Response<R>{
        try{
            val response = call.execute()
            return response
            //handelResponse(response,responseHandler)
        }catch (t: IOException){
            throw  t;
        }

    }

    fun observerProccess() : Single<R> {
        return Single.create<R> { emitter ->
            process { r, throwable ->
                throwable?.let {
                    if(it is SocketTimeoutException){
                        emitter.onError(NoConnection(it.localizedMessage))
                    }else{
                        emitter.onError(it)
                    }

                } ?: r?.let {   emitter.onSuccess(it) }
            }
        }

//        val observer = Single.create<R>()
//
//         process { r, throwable ->
//             throwable?.let {
//                 if(it is SocketTimeoutException){
//                     observer.onError(NoConnection(it.localizedMessage))
//                 }else{
//                     observer.onError(it)
//                 }
//
//             } ?: r?.let {   observer.onNext(it) }
//            observer.onComplete()
//        }
//
//        return observer.observeOn(Schedulers.io())
    }
    // Async Api Call
    fun process(responseHandler: (R?, Throwable?) -> Unit){


        //val subscription = Subscription()


            val callback = object : Callback<R> {
                override fun onFailure(call: Call<R>, t: Throwable) {
                  //  if (!subscription.isDisposed())
                        responseHandler(null,t)
                }
                override fun onResponse(call: Call<R>, response: Response<R>) {
                   // if (!subscription.isDisposed())
                        handelResponse( response,responseHandler)
                }
            }
            call.enqueue(callback)


       // return subscription
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
        val data  = response.body() as? ResponseModel<*>

        if(response.isSuccessful&& data?.isSuccess?:false){
            handler(response.body(),null)
        }else{
            when(response.code()) {
                400 ->  errorHandler(response, handler)// getNewToken(handler, response)
                in 401..500 -> errorHandler(response, handler)
                else -> handler(response.body(),UnknownHostException(data?.message?:"Somthing is wrong try again"))
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
            return gson.fromJson(jsonString, ResponseModel:: class.java)
        }else return null
    }



}