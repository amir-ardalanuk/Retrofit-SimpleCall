package com.example.myapplication.API.DAL

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.MasterApplication
import com.example.myapplication.model.response.EnumsName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable
import java.lang.reflect.Type


enum class PrefrencesStandardKey {
    cartable;

    var keyName:String
    get() {
        return when(this){
            cartable -> "cartable"
        }
    }
    set(value) {}
}


class PrefrencesStandard {

    companion object{

        private var  instance :PrefrencesStandard? = null
        var standard : PrefrencesStandard
            get(){
                if(instance == null){
                    instance = PrefrencesStandard()
                }
                return instance!!
            }
            private set(value) {}
    }

    var  preferences: SharedPreferences?

    private constructor(){
        preferences = MasterApplication.getInstance()?.applicationContext?.getSharedPreferences("diver_pref", Context.MODE_PRIVATE)
    }


    fun saveString(value : String , key: PrefrencesStandardKey){
        preferences?.let {
            it.edit().putString(key.keyName, value).commit()
        }
    }

    fun <T: Serializable> getArray(key: PrefrencesStandardKey,type: Type) : ArrayList<T>? {
        return preferences?.getString(key.keyName,null)?.let {
            val gson = Gson()
            val json = it
            //val type = object : TypeToken<T>(){}.type
            val list :ArrayList<T> = gson.fromJson(json,type)
            return@let list
        }
    }

    fun <T> getObject( key: PrefrencesStandardKey) : T? {
        return preferences?.getString(key.keyName,null)?.let {
            val gson = Gson()
            val json = it
            val type = object : TypeToken<List<T>>(){}.type
            return@let gson.fromJson<T>(json, type)
        }
    }
}

inline fun <reified T> String.fromJson(json: String): T {
    return Gson().fromJson(json, object: TypeToken<T>(){}.type)
}