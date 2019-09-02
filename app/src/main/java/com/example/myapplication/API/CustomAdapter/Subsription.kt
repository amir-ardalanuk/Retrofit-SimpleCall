package com.example.myapplication.API.CustomAdapter

class Subscription {

    private var disposed = false

    fun isDisposed() = disposed

    fun dispose() {
        disposed = true
    }
}