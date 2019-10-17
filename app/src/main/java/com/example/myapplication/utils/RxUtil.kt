package com.example.myapplication.utils

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject

fun <T>  io.reactivex.Observable<T>.bindTo(observable: BehaviorSubject<T>): Disposable? {
    return this.subscribe {
        observable.onNext(it)
    }
}

fun Disposable.addDispose(compositeDisposable: CompositeDisposable?){
    compositeDisposable?.add(this)
}

