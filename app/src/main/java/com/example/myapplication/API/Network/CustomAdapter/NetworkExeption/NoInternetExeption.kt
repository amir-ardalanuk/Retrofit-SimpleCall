package com.example.myapplication.API.Network.CustomAdapter.NetworkExeption

import java.io.IOException

class NoConnectivityException : IOException() {

    override val message: String
        get() = "No connectivity exception"

}