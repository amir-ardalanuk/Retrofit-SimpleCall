package com.example.myapplication.activities.login

import android.os.Bundle
import android.os.PersistableBundle

import com.example.myapplication.Abstracts.BaseActivity
import com.example.myapplication.Abstracts.BaseViewModel
import com.example.myapplication.R
import com.example.myapplication.fragments.account.Authentication
import io.reactivex.disposables.CompositeDisposable

class LoginActivity: BaseActivity<BaseViewModel>() {

    override var viewModel: BaseViewModel? = null
    override var containerViewId: Int = R.id.login_activity_container


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.login_activity)
        showLoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        showLoginFragment()
    }
    private fun showLoginFragment() {
        val begin = this.supportFragmentManager.beginTransaction()
        begin.add(R.id.login_activity_container , Authentication()).commit()
    }
}