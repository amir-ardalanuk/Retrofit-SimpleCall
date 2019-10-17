package com.example.myapplication.API.Network.CustomAdapter.Interceptor

import com.example.myapplication.API.ApiServices
import com.example.myapplication.API.Network.CustomAdapter.NetworkExeption.AuthorizeError
import com.example.myapplication.model.RegisterModel
import com.example.myapplication.model.response.UserResponse
import io.reactivex.exceptions.Exceptions
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class OAuthInterceptor : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        // try the request

        var response = chain.proceed(request)
        return if (!response.isSuccessful && response.code() == 401) {
            val tokenResponse : retrofit2.Response<UserResponse>?

            tokenResponse = ApiServices().refreshToken(RegisterModel(",", ",", ".")).run()
            Exceptions.propagate(AuthorizeError(response.message()))

            if(tokenResponse.isSuccessful){
                response = chain.proceed(request)
            }else{
                Exceptions.propagate(AuthorizeError(response.message()))
            }
            response
        }else{
            response
        }
    }

}