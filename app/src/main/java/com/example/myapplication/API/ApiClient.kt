package com.example.myapplication.API

import android.content.Context
import com.example.myapplication.API.Network.CustomAdapter.Interceptor.ConnectivityInterceptor
import com.example.myapplication.API.Network.CustomAdapter.Interceptor.OAuthInterceptor
import com.example.myapplication.API.Network.CustomAdapter.SimpleCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {

    private var retrofit: Retrofit? = null
    fun getClient(context : Context? = null , baseUrl: String = URL.baseurl): Retrofit {
        if (retrofit == null) {
            val client = OkHttpClient.Builder()
            context?.let { client.addInterceptor(ConnectivityInterceptor(it)) }
            context?.let { client.addInterceptor(OAuthInterceptor()) }

            retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(SimpleCallAdapterFactory.create())
                .build()
        }
        return retrofit!!
    }


}
