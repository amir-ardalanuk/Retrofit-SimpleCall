package com.example.myapplication.fragments.account

import com.example.myapplication.API.AccountServices
import com.example.myapplication.Abstracts.BaseModelApi
import com.example.myapplication.Abstracts.RetryRequest
import com.example.myapplication.model.account.LoginStepsReq
import com.example.myapplication.model.account.UserAccount
import com.example.myapplication.model.request.toRequestBody
import com.example.myapplication.utils.addDispose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable


interface AuthenticateInterface : BaseModelApi {
    fun loginStep1Success(user: UserAccount)
    fun loginStep2Succssed()
}

class AuthenticationApi(
    var viewModelInterface: AuthenticateInterface? = null,
    var bag: CompositeDisposable?
) {


    var user: UserAccount? = null

    fun loginStep1(value: String?) {
        val request = LoginStepsReq(value)
        viewModelInterface?.loading(true)
        AccountServices().loginStep1(request.toRequestBody()).observerProccess()
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread()).subscribe(
            {
                viewModelInterface?.loading(false)
                it?.data?.let {
                    this.user = it
                    viewModelInterface?.loginStep1Success(it)
                }
            },
            {
                viewModelInterface?.loading(false)
                viewModelInterface?.errorHandeling(it, object : RetryRequest {
                    override fun requestAgain() {
                        loginStep1(value)
                    }
                })
            }).addDispose(this.bag)
    }

    fun loginStep2(code:String?) {
        val request = LoginStepsReq(user?.senderNumber,user?.customerId,code).toRequestBody()
        viewModelInterface?.loading(true)

        AccountServices().loginStep2(request).observerProccess().subscribeOn(AndroidSchedulers.mainThread()).subscribe(
            {user ->

                viewModelInterface?.loading(false)

                user?.data?.let {
                    viewModelInterface?.loginStep2Succssed()
                }
            },
            {
                viewModelInterface?.loading(false)
                viewModelInterface?.errorHandeling(it, object : RetryRequest {
                    override fun requestAgain() {
                        loginStep2(code)
                    }
                })
            }).addDispose(this.bag)
    }
}