package com.example.myapplication.Activities.Login

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Abstracts.BaseActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val viewModel = ViewModelProvider.NewInstanceFactory().create(LoginViewModel::class.java)


    }
}