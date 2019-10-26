package com.example.myapplication.fragments.mainLoadFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.FtsOptions
import com.example.myapplication.API.BrokerOrderServices
import com.example.myapplication.Abstracts.BaseModelApi
import com.example.myapplication.Abstracts.RetryRequest
import com.example.myapplication.model.request.BrokerOrderCartableRequest
import com.example.myapplication.model.request.toRequestBody
import com.example.myapplication.model.response.ListResponse
import com.example.myapplication.model.response.Load
import com.example.myapplication.utils.addDispose
import io.reactivex.disposables.CompositeDisposable

interface MainLoadModelInterface : BaseModelApi {
    fun setCartableLoads(items: List<Load>?)

}
class MainLoadApi(val view : MainLoadModelInterface,val bag : CompositeDisposable?) {

    var lastPage = 0;

    fun getLoad(request : BrokerOrderCartableRequest){
        view.loading(true)
        BrokerOrderServices().brokerOrder(request.toRequestBody()).observerProccess().subscribe({
            view.loading(false)
            it.data?.let {
                this.view.setCartableLoads(it.items)
            }
        },{
            view.loading(false)
            this.view.errorHandeling(it,object :RetryRequest{
                override fun requestAgain() {
                    getLoad(request)
                }
            })
        }).addDispose(bag)
    }
}