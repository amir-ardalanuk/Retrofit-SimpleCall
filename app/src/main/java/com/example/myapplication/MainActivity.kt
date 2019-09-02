package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.API.ApiServices
import com.example.myapplication.Model.RegisterModel
import com.example.myapplication.Model.User

class MainViewModel(val view : MainView) {

    interface MainView {
        fun showEmail(message : String?)
        fun showError(message : String?)
    }


    fun callApi(){

        var register = RegisterModel("amir8.aa@gmail.com","amir","123123")
        ApiServices().Register(register).process(){ res, t ->
            val result = res?.data
            when(result){
                is User -> {

                    view.showEmail(result.userProperties?.email)

                }
                else -> view.showError(t?.message ?: "fucking error")
            }

        }
    }

}

class MainActivity : AppCompatActivity(),MainViewModel.MainView {
    override fun showEmail(message: String?) {
        textMessage.setText(message)

        Toast.makeText(this , message,Toast.LENGTH_SHORT)
    }

    override fun showError(message: String?) {
        textMessage.setText(message)
        Toast.makeText(this , message,Toast.LENGTH_SHORT)
    }

    val presenter = MainViewModel(this);

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        presenter.callApi()
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
        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        presenter.callApi()
    }
}
