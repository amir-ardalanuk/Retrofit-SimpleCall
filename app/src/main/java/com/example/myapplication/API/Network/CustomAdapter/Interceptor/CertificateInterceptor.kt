package com.example.myapplication.API.Network.CustomAdapter.Interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class CertificateInterceptor : Interceptor {


    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder1 = chain.request()
            .newBuilder()
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"
            )
        return chain.proceed(builder1.build())
    }

}