package com.example.myapplication.fragments.account

import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.MasterApplication
import com.example.myapplication.model.account.UserAccount
import com.example.myapplication.fragments.account.AuthenticationViewModel.AuthState.*
import com.example.myapplication.utils.ViewState
import com.example.myapplication.utils.addDispose
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.subjects.BehaviorSubject


class AuthenticationViewModel() : BaseViewModel() , AuthenticateInterface {


    enum class AuthState {
        phone , verifyCode ,resend ,Done;

        fun buttonSate(): String {
            return when(this){
                phone -> return "Submit my Phone Number"
                verifyCode -> return "Login"
                resend -> return "resend my Code"
                Done -> "you are registered"
            }
        }
    }

    val apiInerface = AuthenticationApi(this,this.bag);
    val mobileSubject   : BehaviorSubject<String?>      = BehaviorSubject.create();
    val codeSubject     : BehaviorSubject<String?>      = BehaviorSubject.create();
    val stateSubject    : BehaviorSubject<AuthState> = BehaviorSubject.createDefault(phone);
    val buttonTitle         : BehaviorSubject<String?> = BehaviorSubject.create();
    val mobileStateSubject  : BehaviorSubject<ViewState?> = BehaviorSubject.create();
    val codeStateSubject    : BehaviorSubject<ViewState?> = BehaviorSubject.create();

    var userAccount : UserAccount? = null

    init {
        binding()
    }

    fun binding(){
        stateSubject.subscribeOn(AndroidSchedulers.mainThread())
            .doOnError{
            print(it.message)
        }
            .filter{bag?.isDisposed?:false == false}
            .subscribe {
            buttonTitle.onNext(it.buttonSate())
            mobileStateSubject.onNext( if(it == phone) ViewState.Enable else ViewState.Disable)
            codeStateSubject.onNext( if(it == verifyCode) ViewState.Enable else ViewState.Disable)

        }.addDispose(bag)
    }

    fun submitClick(){
        stateSubject.value?.let {
            when(it){
                phone       -> submitNumber()
                verifyCode  -> checkPassword()
                resend      -> resendCode()
                Done        -> succefullyRegister()
            }
        }



    }

    private fun succefullyRegister() {

    }

    private fun resendCode() {

    }

    fun submitNumber(){
        if(mobileSubject.value?.length == 11) {
            apiInerface.loginStep1(mobileSubject.value)
        }else{
            showErrorOnFragment("mobile number isn't valid")
        }
    }

    fun checkPassword(){
        if(codeSubject.value?.length ?:0 >= 4) {
            apiInerface.loginStep2(codeSubject.value)
        }else{
            showErrorOnFragment("code isn't valid - code must be 4 charecter")
        }
    }

    fun verifyCode(){
        if(codeSubject.value?.length ?:0 >= 4) {
            stateSubject.onNext(Done)
        }else{
            showErrorOnFragment("code isn't valid - code must be 4 charecter")
        }
    }

    override fun loginStep1Success(user: UserAccount) {
        user?.let {
            if(it.mobileVerified ?: false) stateSubject.onNext(verifyCode)
            //TODO REgister Form
        }

    }

    override fun loginStep2Succssed() {
        apiInerface.user?.let {
            UserRepository(MasterApplication.getInstance()!!.baseContext).insertTask(it)
            stateSubject.onNext(Done)
        }

    }




}

