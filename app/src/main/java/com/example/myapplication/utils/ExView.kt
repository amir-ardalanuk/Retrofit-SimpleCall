package com.example.myapplication.utils

import android.view.View
import com.jakewharton.rxbinding3.view.visibility

enum class ViewState {
    Enable , Disable;

    fun alpha():Float{
        return when(this){
            Enable -> return 1F
            Disable -> return 0F
        }
    }

    fun visibity():Int{
        when(this){
            Enable -> return View.VISIBLE
            Disable -> return View.GONE
        }
    }

    fun enablity():Boolean{
        when(this){
            Enable -> return true
            Disable -> return false
        }
    }
}

fun View.setState(state : ViewState) {
    this.alpha = state.alpha()
    this.visibility = state.visibity()
    this.isEnabled = state.enablity()
}