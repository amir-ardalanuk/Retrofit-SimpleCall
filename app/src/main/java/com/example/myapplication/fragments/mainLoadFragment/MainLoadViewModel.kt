package com.example.myapplication.fragments.mainLoadFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.API.DAL.PrefrencesStandard
import com.example.myapplication.API.DAL.PrefrencesStandardKey
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.model.account.UserAccount
import com.example.myapplication.model.request.BrokerOrderCartableRequest
import com.example.myapplication.model.response.EnumsName
import com.example.myapplication.model.response.Load
import com.google.gson.reflect.TypeToken

class MainLoadViewModelFactory(private val repository: UserRepository ,
                               private val prefrencesStandard: PrefrencesStandard) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainLoadViewModel(repository,prefrencesStandard) as T
    }
}
class MainLoadViewModel(val repository: UserRepository ,
                        prefrencesStandard: PrefrencesStandard): BaseViewModel(),
    MainLoadModelInterface {


    var loadList  = MutableLiveData<Array<Load>>()
    var headerItem =  MutableLiveData<ArrayList<EnumsName>?>()
    var mModel =  MainLoadApi(this,this.bag)

    init {
        var typeToken = object : TypeToken<ArrayList<EnumsName>>(){}.type;
        headerItem.value = prefrencesStandard.getArray<EnumsName>(PrefrencesStandardKey.cartable ,typeToken )
    }

    fun getLoadList(){
        repository.user?.customerId?.let {
            val orderRequest = BrokerOrderCartableRequest(1,it,null,mModel.lastPage + 1 , 20,"")
            mModel.getLoad(orderRequest)
        }

    }

    override fun setCartableLoads(items: List<Load>?) {
        items?.let { new ->
            loadList.value?.let {
                loadList.value = it.plus(new.toTypedArray())
            } ?: kotlin.run {
                loadList.value = new.toTypedArray()
            }
        }
    }
}
