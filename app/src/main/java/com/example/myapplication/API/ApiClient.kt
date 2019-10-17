package com.example.myapplication.API

import android.content.Context
import com.example.myapplication.API.Network.CustomAdapter.Interceptor.CertificateInterceptor
import com.example.myapplication.API.Network.CustomAdapter.Interceptor.ConnectivityInterceptor
import com.example.myapplication.API.Network.CustomAdapter.Interceptor.OAuthInterceptor
import com.example.myapplication.API.Network.CustomAdapter.SimpleCallAdapterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import javax.net.ssl.*


object ApiClient {

    private var retrofit: Retrofit? = null
    fun getClient(context : Context? = null , baseUrl: String = URL.baseurl): Retrofit {
        if (retrofit == null) {
            val client = getUnsafeOkHttpClient()
            context?.let { client.addInterceptor(ConnectivityInterceptor(it)) }
            context?.let { client.addInterceptor(OAuthInterceptor()) }
            client.addInterceptor(CertificateInterceptor())
            val gson = GsonBuilder().setLenient().create()
            retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(SimpleCallAdapterFactory.create())
                .build()
        }
        return retrofit!!
    }

}

fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
    try {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                return arrayOf()
            }
        })
        // Install the all-trusting trust manager
        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory = sslContext.socketFactory
        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory)
        builder.hostnameVerifier { hostname, session -> true }
        return builder
    } catch (e: Exception) {
        throw RuntimeException(e)
    }

}

