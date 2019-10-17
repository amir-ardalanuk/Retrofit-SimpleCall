package com.example.myapplication.activities.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.API.GeneralServices
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.Abstracts.ContractView
import com.example.myapplication.Abstracts.RetryRequest
import com.example.myapplication.model.request.BaseRequestModel
import com.example.myapplication.model.request.EnumNamesRequest
import com.example.myapplication.model.request.toRequestBody
import com.example.myapplication.model.response.AppSetting
import com.example.myapplication.model.response.EnumsName
import com.example.myapplication.utils.addDispose
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.security.AccessController.getContext
import kotlin.collections.ArrayList

class SplashViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(repository) as T
    }
}
class SplashViewModel(val repository: UserRepository) : BaseViewModel() {

    enum class StateView{
        Home, Login
    }


    init{
        this.bag = CompositeDisposable()
        getData()
        setObserver()
    }

    var cartableItems: BehaviorSubject<ArrayList<EnumsName>?> = BehaviorSubject.create()
    var appSetting: BehaviorSubject<AppSetting?> = BehaviorSubject.create()
    var onChangeState : PublishSubject<StateView> = PublishSubject.create()

    fun setObserver() {
//        Observable.combineLatest<ArrayList<EnumsName>?, AppSetting?, Boolean>(
//            cartableItems,
//            appSetting,
//            BiFunction { cartable, appset ->
//                return@BiFunction arrayOf(
//                    !cartable.isNullOrEmpty(),
//                    (appSetting.value != null)
//                ).all { it == true }
//                //return@BiFunction cartable.isNullOrEmpty() && appSetting.value != null
//            }).filter { it }.subscribe {
//            this.routing()
//        }.addDispose(bag)

    }

    fun getData(){
        getCartableItem()
        getAppSetting()
    }

    fun getCartableItem() {
        val request = EnumNamesRequest("brokerActionCode").toRequestBody()
        this.loading(true)
        GeneralServices().getEnums(request)
            .observerProccess()
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                this.loading(false)
                it.data?.let {
                    if (it.size > 0) cartableItems.onNext(it)
                }
            }, {
                this.loading(false)
                this.errorHandeling(it, object : RetryRequest {
                    override fun requestAgain() {
                        getCartableItem()
                    }
                })
            }).addDispose(bag)

    }

    fun getAppSetting(){
        this.loading(true)
        val req = BaseRequestModel()
        GeneralServices().getSetAppSetting(req.appCode,req.deviceTypeCode)
            .observerProccess()
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                this.loading(false)
                it.data?.let {
                 appSetting.onNext( it)
                }
            }, {
                this.loading(false)
                this.errorHandeling(it, object : RetryRequest {
                    override fun requestAgain() {
                        getCartableItem()
                    }
                })
            }).addDispose(bag)
    }

    fun routing(){
        repository.user?.let {
            onChangeState.onNext(StateView.Home)
        } ?: onChangeState.onNext(StateView.Login)
    }
}