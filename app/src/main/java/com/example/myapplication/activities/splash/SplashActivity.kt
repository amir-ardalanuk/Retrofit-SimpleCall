package com.example.myapplication.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.MainThread
import com.example.myapplication.API.Database.UserRepository
import com.example.myapplication.Abstracts.BaseActivity
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.R
import com.example.myapplication.activities.home.HomeActivity
import com.example.myapplication.activities.login.LoginActivity
import com.example.myapplication.utils.addDispose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_splash.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashActivity : BaseActivity<SplashViewModel>() {

    private val _bag = CompositeDisposable()

    override var viewModel: SplashViewModel? = null

    override var containerViewId: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
        set(value) {}


    override fun onCreate(savedInstanceState: Bundle?) {

        val factory = SplashViewModelFactory(UserRepository(this))
        viewModel = factory.create(SplashViewModel::class.java)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel?.getData()
        subscribe()
    }


    fun subscribe() {
        this.viewModel?.onChangeState?.subscribeOn(AndroidSchedulers.mainThread())
            ?.subscribe {
                when (it) {
                    SplashViewModel.StateView.Login -> gotoLogin()
                    SplashViewModel.StateView.Home -> goToHome()
                }
            }?.addDispose(_bag)
    }

    private fun goToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun gotoLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
