package com.example.myapplication.API.DAL

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.MasterApplication

class PrefrencesStandard {

    companion object{

        private lateinit var  instance :PrefrencesStandard
        var standard : PrefrencesStandard? = null
            get() = instance
    }

    var  preferences: SharedPreferences?

    private constructor(){
        instance = this
        preferences = MasterApplication.getInstance()?.applicationContext?.getSharedPreferences("diver_pref", Context.MODE_PRIVATE)
    }
}