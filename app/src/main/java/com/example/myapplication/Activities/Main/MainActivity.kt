package com.example.myapplication.Activities.Main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.API.ApiServices
import com.example.myapplication.Model.RegisterModel
import com.example.myapplication.Model.User
import com.example.myapplication.R
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject


import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainViewModel(val view : MainView) {

    interface MainView {
        fun showEmail(message : String?)
        fun showError(message : String?)
    }

    val compositeDisposable = CompositeDisposable()

    val emailObserver = BehaviorSubject.create<String?>()
    val passwordObserver = BehaviorSubject.create<String?>()


    fun callApi(){
        val email = emailObserver.value
        val password = passwordObserver.value
        if(email != null && password != null && email.validEmail()){
            var register = RegisterModel( email ?: "amir8.aa@gmail.com","amir",password ?: "123123")
            val data = ApiServices().Register(register).observerProccess()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val result = it?.data
                    when(result) {
                        is User -> {
                            view.showEmail(result.userProperties?.email)
                        }
                    }
                },::errorHandeling, {
                    print("Complete Register Api")
                })
            compositeDisposable.add(data);
        }




//        ApiServices().Register(register).process(){ res, t ->
//            val result = res?.data
//            when(result){
//                is User -> {
//
//                    view.showEmail(result.userProperties?.email)
//
//                }
//                else -> view.showError(t?.message ?: "fucking error")
//            }
//
//        }
    }
    fun errorHandeling(t :Throwable) {
        view.showError(t?.message ?: "fucking error")
    }

}

private fun String.validEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

class MainActivity : AppCompatActivity(), MainViewModel.MainView {
    var bag = CompositeDisposable()
    override fun showEmail(message: String?) {
     //   textMessage.setText(message)

        Toast.makeText(this , message,Toast.LENGTH_SHORT).show()
    }

    override fun showError(message: String?) {
//        textMessage.setText(message)
        Toast.makeText(this , message,Toast.LENGTH_SHORT).show()
    }

    val presenter = MainViewModel(this);

    private lateinit var textMessage: TextView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        et_email.textChanges().map { it.toString() }.bindTo(presenter.emailObserver)?.addDispose(bag)
        et_password.textChanges().map { it.toString() }.bindTo(presenter.passwordObserver)?.addDispose(bag)


        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        btn_main.clicks().debounce(1,TimeUnit.SECONDS).subscribe {
            presenter.callApi()
        }.addDispose(bag)



    }
}

fun Disposable.addDispose(compositeDisposable: CompositeDisposable){
    compositeDisposable.add(this)
}

fun <T>  io.reactivex.Observable<T>.bindTo(observable: BehaviorSubject<T>): Disposable? {
    return this.subscribe {
        observable.onNext(it)
    }

}