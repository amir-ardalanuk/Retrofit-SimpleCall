package com.example.myapplication.Abstracts

import android.content.Context

interface BaseModelApi {
    fun errorHandeling(throwable: Throwable, retryRequest: RetryRequest)
    fun loadingWithLock(state: Boolean)
    fun loading(state: Boolean)
}
