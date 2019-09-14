package com.example.myapplication.Abstracts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myapplication.API.Network.CustomAdapter.NetworkExeption.NoConnectivityException


interface RetryRequest {
    fun requestAgain()
}

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val requestRetry : MutableList<RetryRequest> = mutableListOf()
    var activityInterface : ActivityInterface? = null

    fun  errorHandeling(throwable: Throwable ,request: RetryRequest) {
        if(throwable is NoConnectivityException){
            requestRetry.add(request);
        }
    }

    fun showErrorOnActivity(throwable: Throwable){
        activityInterface?.showError(throwable.message)
    }
}