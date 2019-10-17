package com.example.myapplication.Abstracts

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.API.Network.CustomAdapter.NetworkExeption.NoConnectivityException
import com.example.myapplication.API.Network.CustomAdapter.NoConnection
import io.reactivex.disposables.CompositeDisposable


interface RetryRequest {
    fun requestAgain()
}
interface ContractView {
    fun getContext() : Context
}
enum class BaseViewModelState {
    startLoading,stopLoading,startLockLoading,errorMessage,noInternet;

    var message : String? = null

}
abstract class BaseViewModel : ViewModel(),BaseModelApi {

    val requestRetry : MutableList<RetryRequest> = mutableListOf()

    var activityInterface : ActivityInterface? = null
    var fragmentInterface : FragmentInterface? = null

    var baseState = MutableLiveData<BaseViewModelState>()

    var bag : CompositeDisposable? = null

    var _loading : Boolean = false

    override fun  errorHandeling(throwable: Throwable ,request: RetryRequest) {
        if(throwable is NoConnectivityException || throwable is NoConnection){
            requestRetry.add(request)
            baseState.value = BaseViewModelState.noInternet
        }else{
            val state = BaseViewModelState.errorMessage
            state.message = throwable.localizedMessage
            baseState.value = state
        }

    }

    fun showErrorOnActivity(throwable: Throwable){
        activityInterface?.showError(throwable.message)
    }

    fun showErrorOnFragment(message : String?){
        fragmentInterface?.showError( message)
    }

    override fun loading(state: Boolean) {

    }

    override fun loadingWithLock(state: Boolean) {

    }

}