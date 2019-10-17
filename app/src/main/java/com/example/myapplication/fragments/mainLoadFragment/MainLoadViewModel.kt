package com.example.myapplication.fragments.mainLoadFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.model.account.UserAccount

class MainLoadViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainLoadViewModel(repository) as T
    }
}
class MainLoadViewModel(var repository: UserRepository): BaseViewModel() {

    var loadList  = MutableLiveData<Array<String>>()

    private var user : UserAccount? = null
        get() = repository.user


    fun getLoadList(){

    }
}
