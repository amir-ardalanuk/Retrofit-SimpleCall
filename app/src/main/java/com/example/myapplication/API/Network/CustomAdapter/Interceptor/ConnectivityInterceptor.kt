package com.example.myapplication.API.Network.CustomAdapter.Interceptor

import android.content.Context
import com.example.myapplication.API.Network.CustomAdapter.NetworkExeption.NoConnectivityException
import com.example.myapplication.API.Network.CustomAdapter.NetworkUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ConnectivityInterceptor(private val mContext: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isOnline(mContext)) {
            throw NoConnectivityException()
        }
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}